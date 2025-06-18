package ai.idealistic.vacan.utils.a;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import lombok.Generated;

public final class e {
   public static Class<?> Z(String var0) {
      try {
         return Class.forName(var0);
      } catch (Exception var2) {
         return null;
      }
   }

   public static boolean aa(String var0) {
      try {
         Class.forName(var0);
         return true;
      } catch (ClassNotFoundException var2) {
         return false;
      }
   }

   public static Object a(String var0, String var1, String var2) {
      try {
         File var3 = new File(var0);
         URL var4 = var3.toURI().toURL();
         URLClassLoader var5 = new URLClassLoader(new URL[]{var4});

         Object var8;
         try {
            Class var6 = var5.loadClass(var1);
            Field var7 = var6.getDeclaredField(var2);
            var7.setAccessible(true);
            var8 = var7.get((Object)null);
         } catch (Throwable var10) {
            try {
               var5.close();
            } catch (Throwable var9) {
               var10.addSuppressed(var9);
            }

            throw var10;
         }

         var5.close();
         return var8;
      } catch (Exception var11) {
         return null;
      }
   }

   public static Object a(String var0, String var1, String var2, Class<?>[] var3, Object[] var4) {
      try {
         File var5 = new File(var0);
         URL var6 = var5.toURI().toURL();
         URLClassLoader var7 = new URLClassLoader(new URL[]{var6});

         Object var10;
         try {
            Class var8 = var7.loadClass(var1);
            Method var9 = var8.getDeclaredMethod(var2, var3);
            var9.setAccessible(true);
            var10 = var9.invoke((Object)null, var4);
         } catch (Throwable var12) {
            try {
               var7.close();
            } catch (Throwable var11) {
               var12.addSuppressed(var11);
            }

            throw var12;
         }

         var7.close();
         return var10;
      } catch (Exception var13) {
         return null;
      }
   }

   @Generated
   private e() {
      throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
   }
}
