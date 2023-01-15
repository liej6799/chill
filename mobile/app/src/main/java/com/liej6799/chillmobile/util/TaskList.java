package com.liej6799.chillmobile.util;

import com.liej6799.chillmobile.model.TaskType;
import com.liej6799.chillmobile.model.Tasks;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    public static final String FILL_MASK_TASK = "Fill Mask task";
    public static final String SUMMARIZATION_TASK = "Summarization task";

    public static final String AUTOMATIC_SPEECH_RECOGNITION_TASK = "Automatic Speech Recognition task";
    public static final String AUDIO_CLASSIFICATION_TASK = "Audio Classification task";


    public static final List<Tasks> TASK_LIST = new ArrayList<Tasks>(){{
       add(new Tasks(FILL_MASK_TASK, true, TaskType.NATURAL_LANGUAGE_PROCESSING));
       add(new Tasks(SUMMARIZATION_TASK, false, TaskType.NATURAL_LANGUAGE_PROCESSING));
       add(new Tasks(AUTOMATIC_SPEECH_RECOGNITION_TASK, false, TaskType.AUDIO));
       add(new Tasks(AUDIO_CLASSIFICATION_TASK, false, TaskType.AUDIO));

    }};



}


