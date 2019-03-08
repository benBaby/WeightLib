package com.rasmsey.library.crash;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

/**
 *  意外崩溃 捕捉
 */
//public class CrashHandler implements Thread.UncaughtExceptionHandler {
//
//    private Context mContext;
//
//    @Override
//    public void uncaughtException(Thread t, Throwable e) {
//        //TODO  1.收集错误   2.保存到本地/上传到服务器   3.退出
//        if (!catchCrashException(e) && mDefaultHandler != null) {
//            //没有自定义的CrashHandler的时候就调用系统默认的异常处理方式
//            mDefaultHandler.uncaughtException(t, e);
//        } else {
//            //退出应用
//            killProcess();
//        }
//    }
//
//    /**
//     * 自定义错误处理,收集错误信息 发送错误报告等操作均在此完成.
//     *
//     * @param ex
//     * @return true:如果处理了该异常信息;否则返回false.
//     */
//    private boolean catchCrashException(Throwable ex) {
//        if (ex == null) {
//            return false;
//        }
//
////        new Thread() {
////            @Override
////            public void run() {
////                Intent intent = new Intent();
////                intent.setClass(mContext, CrashActivity.class);
////                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
////                ActivityCollector.finishAll();
////                mContext.startActivity(intent);
////            }
////        }.start();
//
//        //收集设备参数信息
//        collectInfos(mContext, ex);
//        //保存日志文件
////        saveCrashInfo2File();
//        //上传崩溃信息
////        uploadCrashMessage(infos);
//
//        return true;
//    }
//
//    /**
//     * 获取设备参数信息
//     *
//     * @param context
//     */
//    private void collectInfos(Context context, Throwable ex) {
//        mExceptionInfos = collectExceptionInfos(ex);
//        collectPackageInfos(context);
//        collectBuildInfos();
//        collectSystemInfos();
//        collectSecureInfos();
//        mMemInfos = collectMemInfos();
//
//        //将信息储存到一个总的Map中提供给上传动作回调
//        infos.put(EXCEPETION_INFOS_STRING, mExceptionInfos);
//        infos.put(PACKAGE_INFOS_MAP, mPackageInfos);
//        infos.put(BUILD_INFOS_MAP, mDeviceInfos);
//        infos.put(SYSTEM_INFOS_MAP, mSystemInfos);
//        infos.put(SECURE_INFOS_MAP, mSecureInfos);
//        infos.put(MEMORY_INFOS_STRING, mMemInfos);
//    }
//
//    /**
//     * 退出应用
//     */
//    public void killProcess() {
//        //结束应用
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Looper.prepare();
//                Toast.makeText(mContext, "哎呀，程序发生异常啦...", Toast.LENGTH_SHORT).show();
//                Looper.loop();
//            }
//        }).start();
//
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException ex) {
//            Log.e("TAG","CrashHandler.InterruptedException--->" + ex.toString());
//        }
//        //退出程序
//        Process.killProcess(Process.myPid());
//        System.exit(1);
//    }
//}
