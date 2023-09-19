package com.gaurneev.mentalhelper

import com.gaurneev.mentalhelper.ExerciseModel

object Constants {

    fun defaultExerciseList(): ArrayList<ExerciseModel>
    {
        val exerciseList= ArrayList<ExerciseModel>()


        val jumpingJacks= ExerciseModel(1, "Jump rope", R.drawable.jumping_ropes, false, false)
        exerciseList.add(jumpingJacks)

        val fishPose= ExerciseModel(2, "Aerobic strength circuit", R.drawable.aerobic_ciruit, false, false)
        exerciseList.add(fishPose)

        val invertedVPlank= ExerciseModel(3, "Running or jogging", R.drawable.running, false, false)
        exerciseList.add(invertedVPlank)

        val lunge= ExerciseModel(4, "Walking", R.drawable.wallk_jog, false, false)
        exerciseList.add(lunge)

        val pushUp= ExerciseModel(5, "Swimming", R.drawable.swimming, false, false)
        exerciseList.add(pushUp)

        val sidePlank= ExerciseModel(6, "Zumba", R.drawable.zumba1, false, false)
        exerciseList.add(sidePlank)

        val squat= ExerciseModel(7, "Balasana", R.drawable.balasana, false, false)
        exerciseList.add(squat)

        val stepUpOnTheChair= ExerciseModel(8, "Sukhasana", R.drawable.sukhasana, false, false)
        exerciseList.add(stepUpOnTheChair)

        val tricepsDipOnChair= ExerciseModel(9, "Bakasana", R.drawable.bakasana, false, false)
        exerciseList.add(tricepsDipOnChair)

        val wallSit= ExerciseModel(10, "Paschimottanasana", R.drawable.paschimottanasana, false, false)
        exerciseList.add(wallSit)

        val highKneesRunningPlace= ExerciseModel(11, "Chakrasana", R.drawable.chakrasana, false, false)
        exerciseList.add(highKneesRunningPlace)


        return exerciseList
    }
}