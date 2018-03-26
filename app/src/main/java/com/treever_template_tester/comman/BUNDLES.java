package com.treever_template_tester.comman;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Abgaryan on 9/16/15.
 */

/*
  This enums used for  store phone orientation state,
  initialize player start time , and show is player finished
 */
public enum BUNDLES {

    // player bundles
    MS_SINCE_START(101),
    IS_EDITING(102),
    IS_ROTATING(103),
    ANIM_STATE(104),
    IS_FINISHED(105);


    private static final Map<Integer,BUNDLES> lookup
            = new HashMap<Integer,BUNDLES>();

    static {
        for(BUNDLES s : EnumSet.allOf(BUNDLES.class))
            lookup.put(s.getCode(), s);
    }

    private int code = 0;

    private BUNDLES(int code) {
        this.code = code;
    }

    public int getCode() { return code; }

    public static BUNDLES get(int code) {
        return lookup.get(code);
    }



    }
