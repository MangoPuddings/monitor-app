package com.onlydoone.busposition.Utils;

import android.content.Context;
import android.widget.Toast;

/**
 *      Created by zhaohui on 2017/4/12.
 * Toast工具箱  可防止用户多次点击之后 显示消息的时长太长
 */
public class ToastUtils {

    private static String oldMsg;
    protected static Toast toast   = null;
    private static long oneTime=0;
    private static long twoTime=0;
    /**
     * 吐出一个显示时间较短的提示
     * @param context 上下文
     * @param s  文本内容
     */
    public static void showToast(Context context, String s){
        if(toast == null){
            toast = Toast.makeText(context, s, Toast.LENGTH_SHORT);
            toast.show();
            oneTime = System.currentTimeMillis();
        }else{
            twoTime=System.currentTimeMillis();
            if(s.equals(oldMsg)){
                if(twoTime-oneTime>Toast.LENGTH_SHORT){
                    toast.show();
                }
            }else{
                oldMsg = s;
                toast.setText(s);
                toast.show();
            }
        }
        oneTime = twoTime;
    }
}
