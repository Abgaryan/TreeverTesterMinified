package com.treever_template_tester.comman;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Abgaryan on 9/15/15.
 */
/*
  This enums used for store treeve player states.
 */
public enum AnimationStates {
    INITIAL(0),
    PLAYING(1),
    PAUSED(2),
    FINISHED(3);

    private static final Map<Integer,AnimationStates> lookup
            = new HashMap<Integer,AnimationStates>();

    static {
        for(AnimationStates s : EnumSet.allOf(AnimationStates.class))
            lookup.put(s.getCode(), s);
    }

    private int code = 0;

    private AnimationStates(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;

    }

    public static AnimationStates get(int code) {
        return lookup.get(code);
    }

}
