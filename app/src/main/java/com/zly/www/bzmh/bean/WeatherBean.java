package com.zly.www.bzmh.bean;

/**
 * Created by zly on 2015/11/30.
 */
public class WeatherBean extends BaseBean{
    public WeatherInfo weatherinfo;

    public class WeatherInfo{
        public String Radar;
        public String SD;
        public String WD;
        public String WS;
        public String WSE;
        public String city;
        public String cityid;
        public String isRadar;
        public String temp;
        public String time;
    }
}
