package com.tjut.common;

import java.util.HashMap;
import java.util.Map;

public class ProgrammeCommon {
    public static final Map<Integer, String> typeMap = new HashMap<>();
    static {
        typeMap.put(1,"歌舞");
        typeMap.put(2,"戏曲");
        typeMap.put(3,"小品");
        typeMap.put(4,"相声");
        typeMap.put(5,"武术");
        typeMap.put(6,"其他");
    }
    public static int myGetActorNum(String actors){
        int cnt = 1;
        for(int i = 0;i<actors.length();i++){
            char c= actors.charAt(i);
            if(c == '，') cnt++;
        }
        return cnt;
    }
    public static String resetType(String type){
        return ProgrammeCommon.typeMap.get(Integer.valueOf(type));
    }


}
