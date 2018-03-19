package com.treever_template_tester.comman;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Base64;
import android.util.TypedValue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Abgaryan on 3/12/18.
 */

public class Utils {
    public static String listToString(final List<String> stringList){
        if(stringList == null || stringList.isEmpty()){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for(String s: stringList){
            sb.append(s);
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }

    public static boolean isEmailValid(final String hex) {
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher(hex);
        return matcher.matches();

    }

    public static String getToken(Context context){
        String key = context.getSharedPreferences(Constants.SHARED_PREFERENCE, Context.MODE_PRIVATE).getString(Constants.KEY_TOKEN, null);

        return key == null ? null : Constants.TOKEN + key;
    }

    public static boolean isWiFiConnected(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

        return networkInfo.isConnected();
    }

    public static String getUniqueID(){
        final Random random = new Random();
        final byte[] randomBytes = new byte[32];
        random.nextBytes(randomBytes);
        return Base64.encodeToString(randomBytes, Base64.NO_WRAP | Base64.NO_PADDING);
    }


    public static int DPToPX(Context context, int DP){
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, DP, context.getResources().getDisplayMetrics());
    }




    public static String rotateDateString(final String date, final String from, final String to){
        SimpleDateFormat input = new SimpleDateFormat(from, Locale.FRANCE);
        SimpleDateFormat output = new SimpleDateFormat(to, Locale.FRANCE);

        Date ds = null;

        try {
            ds = input.parse(date);
        } catch (ParseException e) {
            return "NaN";
        }

        System.out.println(ds.getTime());
        return output.format(new Date(ds.getTime()));
    }

    public static long getTimeFromString(final String date, final String format){
        SimpleDateFormat input = new SimpleDateFormat(format, Locale.FRANCE);

        long result = 0;

        try{
            result = input.parse(date).getTime();
        }catch (Throwable t){

        }

        return result;
    }



    public static long parseSimpleDateFormat(String date) {
        if(date == null) {
            return System.currentTimeMillis();
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date time = null;
        try {
            time = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return System.currentTimeMillis();
        }
        return time.getTime();
    }

    public static String convertDateFromat(String date) {
        final String OLD_FORMAT = "yyyy-MM-dd";
        final String NEW_FORMAT = "MM-yyy";

        String oldDateString = date;
        String newDateString;

        SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT, Locale.GERMANY);
        Date d = null;
        try {
            d = sdf.parse(oldDateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        sdf.applyPattern(NEW_FORMAT);
        return sdf.format(d);
    }

    public static String convertDateFromat(String date, String oldFormat, String newFormat) {
        String oldDateString = date;
        String newDateString;

        SimpleDateFormat sdf = new SimpleDateFormat(oldFormat, Locale.GERMANY);
        Date d = null;
        try {
            d = sdf.parse(oldDateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        sdf.applyPattern(newFormat);
        return sdf.format(d);
    }





}
