package com.example.bootmaven.tools;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @program: JavaApp
 * @description: class转换
 * @author: SKH
 * @create: 2018-12-04 09:51
 **/
public class PojoConvertUtils {
    public PojoConvertUtils() {
    }

    /*
     * @description：
     * @param： [objsrc, objdest]
     * @return： java.lang.Object
     * @author： caowujun
     * @date： 2019/4/29
     */
    public static Object translate_public_field(Object objsrc, Object objdest) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
        Class classSrc = objsrc.getClass();
        Class classDest = objdest.getClass();
        Field[] fieldListDest = classDest.getDeclaredFields();
        Field[] fieldListSrc = classDest.getDeclaredFields();
        System.out.println(fieldListDest.length);

        for (Field item : fieldListSrc) {
            item.setAccessible(true);
        }
        for (int var10 = 0; var10 < fieldListDest.length; ++var10) {
            Field var11 = fieldListDest[var10];
            Field var12 = fieldListSrc[var10];
            var11.setAccessible(true);
            var12.setAccessible(true);
            var11.set(objdest, classSrc.getDeclaredField(var11.getName()).get(objsrc));
            System.out.println(var11.getName() + ":" + classSrc.getDeclaredField(var11.getName()).get(objsrc));
        }

        return objdest;

    }

    /*
     * @description：
     * @param： [objsrc, objdest]
     * @return： java.lang.Object
     * @author： caowujun
     * @date： 2019/4/29
     */
    public static Object translate_public_method(Object objsrc, Object objdest) {
        Class classsrc = objsrc.getClass();
        Class classdest = objdest.getClass();
        Method[] methodlistdest = classdest.getMethods();
        System.out.println(methodlistdest.length);
        Method[] arr$ = methodlistdest;
        int len$ = methodlistdest.length;

        for (int i$ = 0; i$ < len$; ++i$) {
            Method method = arr$[i$];
            String methodname = method.getName();
            String begin = methodname.substring(0, 3);
            System.out.println(begin);
            String end = methodname.substring(3);
            System.out.println(end);
            if ("set".equals(begin)) {
                System.out.println(method.getName() + "选中");

                try {
                    method.invoke(objdest, new Object[]{classsrc.getMethod("get" + end, (Class[]) null).invoke(objsrc, (Object[]) null)});
                } catch (IllegalAccessException var13) {
                    var13.printStackTrace();
                } catch (IllegalArgumentException var14) {
                    var14.printStackTrace();
                } catch (InvocationTargetException var15) {
                    var15.printStackTrace();
                } catch (NoSuchMethodException var16) {
                    System.out.println(method.getName() + "跳过");
                } catch (SecurityException var17) {
                    var17.printStackTrace();
                }
            } else {
                System.out.println("源对象没有方法：get" + end);
            }
        }

        return objdest;
    }
}
