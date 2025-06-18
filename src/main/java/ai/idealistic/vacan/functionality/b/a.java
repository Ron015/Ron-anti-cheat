package ai.idealistic.vacan.functionality.b;

import ai.idealistic.vacan.utils.a.c;
import ai.idealistic.vacan.utils.a.i;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.logging.Logger;
import lombok.Generated;

public final class a {
   @Generated
   private static final Logger if = Logger.getLogger(ai.idealistic.vacan.functionality.b.a.class.getName());
   private static boolean ig = false;
   private static final char ih = '$';
   public static int ii = 750;
   private static final ScheduledExecutorService ij = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors(), (new ThreadFactoryBuilder()).setNameFormat("Vacan Thread %d").build());
   private static final Map<String, Boolean> ik = new c(new ConcurrentHashMap(), 128);

   public static void ew() {
      ScheduledExecutorService var10000 = ij;
      Objects.requireNonNull(var10000);
      i.b(var10000::shutdownNow);
   }

   public static Future<?> b(Runnable var0) {
      return ij.submit(new ai.idealistic.vacan.functionality.b.a.b(var0));
   }

   public static <T> Future<T> a(Callable<T> var0) {
      return ij.submit(new ai.idealistic.vacan.functionality.b.a.a(var0));
   }

   public static ScheduledFuture<?> a(Runnable var0, long var1, TimeUnit var3) {
      return ij.schedule(new ai.idealistic.vacan.functionality.b.a.b(var0), var1, var3);
   }

   public static ScheduledFuture<?> a(Runnable var0, long var1, long var3, TimeUnit var5) {
      return ij.scheduleAtFixedRate(new ai.idealistic.vacan.functionality.b.a.b(var0), var1, var3, var5);
   }

   public static void a(ScheduledFuture<?> var0) {
      try {
         if (var0 != null) {
            var0.cancel(true);
         }
      } catch (Exception var2) {
      }

   }

   private static String f(Object var0) {
      if (var0 == null) {
         return "null";
      } else {
         Class var1 = var0.getClass();
         StringBuilder var2 = new StringBuilder(var1.getSimpleName() + "{");
         Field[] var3 = var1.getDeclaredFields();

         for(int var4 = 0; var4 < var3.length; ++var4) {
            Field var5 = var3[var4];
            var5.setAccessible(true);

            try {
               if (var5.getName().indexOf(36) != -1) {
                  var2.append(var5.getName()).append("=");
                  Object var6 = var5.get(var0);
                  var2.append(var6 == null ? "null" : var6.toString());
               }
            } catch (IllegalAccessException var7) {
               var2.append(var5.getName()).append("=<access denied>");
            }

            if (var4 < var3.length - 1) {
               var2.append(", ");
            }
         }

         var2.append("}");
         return var2.toString();
      }
   }

   @Generated
   private a() {
      throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
   }

   @Generated
   public static ScheduledExecutorService ex() {
      return ij;
   }

   public static class b implements Runnable {
      private static Function<Runnable, Runnable> il = (var0) -> {
         return var0;
      };
      private final Runnable io;
      private final Runnable ip;

      public b(Runnable var1) {
         this.io = var1;
         this.ip = (Runnable)il.apply(var1);
      }

      public void run() {
         long var1 = System.currentTimeMillis();
         boolean var12 = false;

         long var3;
         String var5;
         label127: {
            try {
               var12 = true;
               this.ip.run();
               var12 = false;
               break label127;
            } catch (Throwable var13) {
               if (ai.idealistic.vacan.functionality.b.a.ig || ai.idealistic.vacan.functionality.b.a.ik.putIfAbsent(var13.getMessage(), true) == null) {
                  ai.idealistic.vacan.functionality.b.a.if.severe("Error during execution of asynchronous task:");
                  var13.printStackTrace();
                  throw var13;
               }

               var12 = false;
            } finally {
               if (var12) {
                  if (ai.idealistic.vacan.functionality.b.a.ig) {
                     long var7 = System.currentTimeMillis() - var1;
                     if (var7 > (long)ai.idealistic.vacan.functionality.b.a.ii) {
                        String var9 = ai.idealistic.vacan.functionality.b.a.f(this.io);
                        if (var9.length() > 26) {
                           var9 = var9.substring(0, 26) + "...";
                        }

                        ai.idealistic.vacan.functionality.b.a.if.warning("Busy task " + var9 + ", it was performed " + var7 + "ms.");
                     }
                  }

               }
            }

            if (ai.idealistic.vacan.functionality.b.a.ig) {
               var3 = System.currentTimeMillis() - var1;
               if (var3 > (long)ai.idealistic.vacan.functionality.b.a.ii) {
                  var5 = ai.idealistic.vacan.functionality.b.a.f(this.io);
                  if (var5.length() > 26) {
                     var5 = var5.substring(0, 26) + "...";
                  }

                  ai.idealistic.vacan.functionality.b.a.if.warning("Busy task " + var5 + ", it was performed " + var3 + "ms.");
                  return;
               }
            }

            return;
         }

         if (ai.idealistic.vacan.functionality.b.a.ig) {
            var3 = System.currentTimeMillis() - var1;
            if (var3 > (long)ai.idealistic.vacan.functionality.b.a.ii) {
               var5 = ai.idealistic.vacan.functionality.b.a.f(this.io);
               if (var5.length() > 26) {
                  var5 = var5.substring(0, 26) + "...";
               }

               ai.idealistic.vacan.functionality.b.a.if.warning("Busy task " + var5 + ", it was performed " + var3 + "ms.");
            }
         }

      }

      @Generated
      public String toString() {
         return "CheckThread.DecoratedRunnable(originalRunnable=" + this.io + ", decoratedRunnable=" + this.ip + ")";
      }

      @Generated
      public static void a(Function<Runnable, Runnable> var0) {
         il = var0;
      }
   }

   public static class a<T> implements Callable<T> {
      private static Function<Callable<?>, Callable<?>> il = (var0) -> {
         return var0;
      };
      private final Callable<T> im;
      private final Callable<T> in;

      public a(Callable<T> var1) {
         this.im = var1;
         this.in = (Callable)il.apply(var1);
      }

      public T call() {
         long var1 = System.currentTimeMillis();
         boolean var13 = false;

         Object var3;
         try {
            var13 = true;
            var3 = this.in.call();
            var13 = false;
         } catch (Throwable var14) {
            if (ai.idealistic.vacan.functionality.b.a.ig || ai.idealistic.vacan.functionality.b.a.ik.putIfAbsent(var14.getMessage(), true) == null) {
               ai.idealistic.vacan.functionality.b.a.if.severe("Error while accepting to call method: " + ai.idealistic.vacan.functionality.b.a.f(this.im));
               var14.printStackTrace();
            }

            throw var14;
         } finally {
            if (var13) {
               if (ai.idealistic.vacan.functionality.b.a.ig) {
                  long var8 = System.currentTimeMillis() - var1;
                  if (var8 > (long)ai.idealistic.vacan.functionality.b.a.ii) {
                     String var10 = ai.idealistic.vacan.functionality.b.a.f(this.im);
                     if (var10.length() > 26) {
                        var10 = var10.substring(0, 26) + "...";
                     }

                     ai.idealistic.vacan.functionality.b.a.if.warning("Busy task " + var10 + ", it was performed " + var8 + "ms.");
                  }
               }

            }
         }

         if (ai.idealistic.vacan.functionality.b.a.ig) {
            long var4 = System.currentTimeMillis() - var1;
            if (var4 > (long)ai.idealistic.vacan.functionality.b.a.ii) {
               String var6 = ai.idealistic.vacan.functionality.b.a.f(this.im);
               if (var6.length() > 26) {
                  var6 = var6.substring(0, 26) + "...";
               }

               ai.idealistic.vacan.functionality.b.a.if.warning("Busy task " + var6 + ", it was performed " + var4 + "ms.");
            }
         }

         return var3;
      }

      @Generated
      public String toString() {
         return "CheckThread.DecoratedCallable(originalCallable=" + this.im + ", decoratedCallable=" + this.in + ")";
      }

      @Generated
      public static void a(Function<Callable<?>, Callable<?>> var0) {
         il = var0;
      }
   }
}
