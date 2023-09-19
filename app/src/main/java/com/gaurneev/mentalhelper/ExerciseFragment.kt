package com.gaurneev.mentalhelper

import android.app.Dialog
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.os.CountDownTimer
import android.speech.tts.TextToSpeech
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.gaurneev.mentalhelper.databinding.DialogCustomBackConformationBinding
import com.gaurneev.mentalhelper.databinding.FragmentExerciseBinding
import java.util.Locale

class ExerciseFragment : Fragment() {

    private var binding: FragmentExerciseBinding?= null

    private var restTimer: CountDownTimer?= null
    private var restProgress= 0
    private val restTimerDuration: Long= 10
    private val exerciseTimerDuration: Long= 30

    private var exerciseTimer: CountDownTimer?= null
    private var exerciseProgress= 0

    private var exerciseList: ArrayList<ExerciseModel>?= null
    private var currentExercisePosition: Int= -1

    private var tts: TextToSpeech?= null
    private var player: MediaPlayer?= null

    private var exerciseAdapter: ExerciseStatusAdapter?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding= FragmentExerciseBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding?.toolbarExercise?.let { toolbar ->
//            (requireActivity() as AppCompatActivity).setSupportActionBar(toolbar)
//
//            // Enable the Up button (back button)
//            (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
//
//            // Set the navigation click listener
//            toolbar.setNavigationOnClickListener {
//                customDialogBackButton()
//            }
//        }

        // Initialize other variables and UI elements
        exerciseList = Constants.defaultExerciseList()
//        tts = TextToSpeech(requireContext(), this)

        setRestView()
        setupExerciseStatusRecycleView()
    }

    private fun customDialogBackButton() {
        val customDialog = Dialog(requireContext())
        val dialogBinding = DialogCustomBackConformationBinding.inflate(layoutInflater)
        customDialog.setContentView(dialogBinding.root)
        customDialog.setCanceledOnTouchOutside(false)
        dialogBinding.tvYes.setOnClickListener {
            customDialog.dismiss()
            requireActivity().onBackPressed()
        }
        dialogBinding.tvNO.setOnClickListener {
            customDialog.dismiss()
        }
        customDialog.show()
    }

    private fun setupExerciseStatusRecycleView()
    {
        binding?.rvExerciseStaus?.layoutManager= LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        exerciseAdapter= ExerciseStatusAdapter(exerciseList!!)
        binding?.rvExerciseStaus?.adapter= exerciseAdapter
    }

    private fun setExerciseView()
    {
        binding?.flRestView?.visibility= View.INVISIBLE
        binding?.tvTitle?.visibility= View.INVISIBLE
        binding?.tvUpComingLavel?.visibility= View.INVISIBLE
        binding?.tvUpComingExerciseName?.visibility= View.INVISIBLE
        binding?.tvExerciseName?.visibility= View.VISIBLE
        binding?.flExreciseView?.visibility= View.VISIBLE
        binding?.ivImage?.visibility= View.VISIBLE

        if (exerciseTimer!= null)
        {
            exerciseTimer?.cancel()
            exerciseProgress= 0
        }

//        speakOut(exerciseList!![currentExercisePosition].getName())

        binding?.ivImage?.setImageResource(exerciseList!![currentExercisePosition].getImage())
        binding?.tvExerciseName?.text= exerciseList!![currentExercisePosition].getName()

        setExerciseRestProgressBar()
    }

    private fun setRestView()
    {

        try {
            val soundURI= Uri.parse("android.resource://com.example.a7minuteworkout/" + R.raw.groovehit)
            player= MediaPlayer.create(requireActivity(), soundURI)
            player?.isLooping= false
            player?.start()
        }catch (e: Exception){
            e.printStackTrace()
        }

        binding?.flRestView?.visibility= View.VISIBLE
        binding?.tvTitle?.visibility= View.VISIBLE
        binding?.tvUpComingLavel?.visibility= View.VISIBLE
        binding?.tvUpComingExerciseName?.visibility= View.VISIBLE
        binding?.tvExerciseName?.visibility= View.INVISIBLE
        binding?.flExreciseView?.visibility= View.INVISIBLE
        binding?.ivImage?.visibility= View.INVISIBLE

        if (restTimer!= null)
        {
            restTimer?.cancel()
            restProgress= 0
        }

        binding?.tvUpComingExerciseName?.text= exerciseList!![currentExercisePosition+ 1].getName()
        setRestProgressBar()
    }

    private fun setRestProgressBar()
    {
        binding?.progressBar?.progress= restProgress

        restTimer= object: CountDownTimer(restTimerDuration* 1000, 1000)
        {
            override fun onTick(p0: Long) {
                restProgress++
                binding?.progressBar?.progress= 10- restProgress
                binding?.tvTimer?.text= (10-restProgress).toString()
            }

            override fun onFinish() {
                currentExercisePosition++

                exerciseList!![currentExercisePosition].setIsSelected(true)
                exerciseAdapter!!.notifyDataSetChanged()

                setExerciseView()
            }

        }.start()
    }

    private fun setExerciseRestProgressBar()
    {
        binding?.progressBarExercise?.progress= exerciseProgress

        exerciseTimer= object: CountDownTimer(exerciseTimerDuration* 1000, 1000)
        {
            override fun onTick(p0: Long) {
                exerciseProgress++
                binding?.progressBarExercise?.progress= 30- exerciseProgress
                binding?.tvTimerExercise?.text= (30-exerciseProgress).toString()
            }

            override fun onFinish() {


                if(currentExercisePosition+1< exerciseList!!.size)
                {
                    exerciseList!![currentExercisePosition].setIsSelected(false)
                    exerciseList!![currentExercisePosition].setIsCompleted(true)
                    exerciseAdapter!!.notifyDataSetChanged()
                    setRestView()
                }
                else
                {
//                    finish()
                    val destinationFragment = CureFragment()
                    val fragmentManager = requireActivity().supportFragmentManager
                    val transaction = fragmentManager.beginTransaction()
                    transaction.replace(R.id.container, destinationFragment)
                    transaction.addToBackStack(null) // Optional, for back navigation
                    transaction.commit()
                }
            }

        }.start()
    }

    override fun onDestroy() {
        super.onDestroy()

        if (restTimer!= null)
        {
            restTimer?.cancel()
            restProgress= 0
        }
        if (exerciseTimer!= null)
        {
            exerciseTimer?.cancel()
            exerciseProgress= 0
        }

        // if activity is closed then shut down the Bol Bachhan
        if(tts!= null)
        {
            tts!!.stop()
            tts!!.shutdown()
        }

        if(player!= null)
        {
            player!!.stop()
        }
        binding= null
    }

    fun onInit(status: Int) {
        if(status== TextToSpeech.SUCCESS)
        {
            val result= tts?.setLanguage(Locale.UK)
        }
        else
        {
            if(status== TextToSpeech.LANG_MISSING_DATA || status== TextToSpeech.LANG_NOT_SUPPORTED)
            {
                Log.e("TTS", "The language specified is not supported")
            }
            else{
                Log.e("TTS", "Initialization failed!")
            }
        }
    }

    private fun speakOut(text: String)
    {
        tts!!.speak(text, TextToSpeech.QUEUE_FLUSH, null, "")
    }
}