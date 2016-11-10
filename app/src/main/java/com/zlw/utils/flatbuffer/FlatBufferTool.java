//package com.zlw.utils.flatbuffer;
//
//import android.util.Log;
//
//import com.zlw.a119_flatbuffer2.flatmodel.Student;
//import com.zlw.a119_flatbuffer2.javamoder.StudentBean;
//
//import java.lang.reflect.Field;
//import java.lang.reflect.Method;
//import java.nio.ByteBuffer;
//
///**
// * Created by zlw on 2016/11/9 0009.
// */
//public class FlatBufferTool {
//
////    private static FlatBufferBuilder builder;
//
////    /**
////     * 思路：
////     * 1.先构建 集合、对象类型， 再构建基本类型
////     * 2.若集合、对象类型中含有集合、对象类型则先构建集合、对象类型
////     * 3.同上 循环.....
////     * 综上所述-应当使用递归执行
////     * <p/>
////     * 如何构建？
////     * 由于对象未知，则必须使用反射机制实现
////     *
////     * @param obj
////     * @return
////     */
////    public static <T> ByteBuffer toBuffer(T obj) {
////
////        StudentBean stu = new StudentBean(1, "zlw");
////        builder = new FlatBufferBuilder();
////        int stuID = createObj(stu, StudentBean.class);
////
////        return null;
////    }
////
////
////    public static int createObj(String s) {
////
////        return 0;
////    }
////
////    public static <E> int createObj(Object obj, Class<E> clazz) {
////        E e = (E) obj;
////        //通过反射获取所有的属性
////        try {
////            Field[] fs = clazz.getDeclaredFields();
////
////            for (int i = 0; i < fs.length; i++) {
////                Field f = fs[i];
////                String fname = f.getName();
////                fname = firstTextD(fname);//首字母大写
////                Class fType = f.getType();
////                if ("Integer".equals(getBaseType(fType))) {
////
////                    Method builder_method = (builder.getClass().getMethod("addInteger", new Class[]{fType}));
////                    Method e_method = (builder.getClass().getMethod("get" + fname, null));
////
////                    int eID = (int) e_method.invoke(e, null);
////                    builder_method.invoke(builder, eID);
////                    builder.createString("zlw1");
////                } else {
////
////                }
////
////            }
////
////        } catch (Exception e1) {
////            e1.printStackTrace();
////        }
////        return 0;
////    }
////
////    public static String getBaseType(Class c) {
////        Object newInstance = null;
////        try {
////            newInstance = c.newInstance();
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////        if (newInstance instanceof String) {
////            return "String";
////        }
////        if (newInstance instanceof Integer) {
////            return "Integer";
////        }
////
////        return "Object";
////    }
//
//    public static String firstTextD(String str) {
//        return str.substring(0, 1).toUpperCase() + str.replaceFirst("\\w", "");
//    }
//
//    public static int createStudent(FlatBufferBuilder builder, StudentBean data, Class stu_clazz) {
//        int stuID = 0;
//        /**
//         * 普通构建入下
//         * 当类未知时 需考虑如下情况：
//         * Student未知
//         * createStudent未知
//         * 参数数量未知
//         * 参数类型未知
//         */
////        int stuId = Student.createStudent(builder, data.getId(), builder.createString(data.getName()));
//
//        try {
//
//            //获取参数
//            Field[] fs = stu_clazz.getFields();
//            int len = fs.length;
//            Class[] cs = new Class[len + 1];
//            Object[] os = new Object[len + 1];
//            cs[0] = builder.getClass();
//            os[0] = builder;
//            for (int i = 0; i < len; i++) {
//                Field f = fs[i];
//                Object o = f.getType().newInstance();
//                if (o instanceof Integer) {
//                    cs[i + 1] = int.class;
//                    os[i + 1] = data.getId();//TODO:
//                } else if (o instanceof String) {
//                    cs[i + 1] = int.class;
//                    os[i + 1] = builder.createString(data.getName());//TODO:
//                }
//            }
//
//            Method create_Method = stu_clazz.getMethod("createStudent", cs);
//
//            //构建参数
//            stuID = (int) create_Method.invoke(os);
//
//
//        } catch (Exception e) {
//            Log.i("zlw", "出错了");
//            e.printStackTrace();
//        }
//
//        return stuID;
//    }
//}
