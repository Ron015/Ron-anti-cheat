package ai.idealistic.vacan.functionality.b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class b {
   private static boolean enabled = true;
   private static final Map<String, Boolean> iq = new ConcurrentHashMap();

   public static void eB() {
      enabled = false;
      ai.idealistic.vacan.functionality.b.a.ew();
   }

   public static boolean a(Thread var0) {
      return iq.containsKey(var0.getName());
   }

   public static class a {
      private final Thread ir;
      private final List<Runnable> is = Collections.synchronizedList(new LinkedList());
      private boolean it = false;

      public a(long var1) {
         this.ir = new Thread(() -> {
            this.r(var1);
         });
         b.iq.put(this.ir.getName(), true);
         this.ir.start();
      }

      private void r(long var1) {
         try {
            while(b.enabled) {
               if (this.it) {
                  Thread.sleep(var1);
               } else {
                  Runnable var3;
                  synchronized(this.is) {
                     var3 = this.is.isEmpty() ? null : (Runnable)this.is.remove(0);
                  }

                  if (var3 != null) {
                     var3.run();
                  } else {
                     Thread.sleep(var1);
                  }
               }
            }

            this.is.clear();
            b.iq.remove(Thread.currentThread().getName());
         } catch (Throwable var7) {
            throw var7;
         }
      }

      public boolean d(Runnable var1) {
         synchronized(this.is) {
            if (this.is.isEmpty()) {
               return this.is.add(var1);
            } else {
               var1.run();
               return false;
            }
         }
      }

      public boolean e(Runnable var1) {
         synchronized(this.is) {
            if (!this.is.isEmpty()) {
               return false;
            } else {
               this.is.add(var1);
               return true;
            }
         }
      }

      public boolean f(Runnable var1) {
         synchronized(this.is) {
            return this.is.add(var1);
         }
      }

      public boolean g(Runnable var1) {
         if (b.a(Thread.currentThread())) {
            var1.run();
            return true;
         } else {
            synchronized(this.is) {
               return this.is.add(var1);
            }
         }
      }

      public boolean h(Runnable var1) {
         synchronized(this.is) {
            if (this.is.isEmpty()) {
               return this.is.add(var1);
            } else {
               ArrayList var3 = new ArrayList(this.is.size() + 1);
               var3.add(var1);
               var3.addAll(this.is);
               this.is.clear();
               return this.is.addAll(var3);
            }
         }
      }

      public boolean eE() {
         boolean var1 = this.it;
         this.it = true;
         return !var1;
      }

      public boolean eF() {
         boolean var1 = this.it;
         this.it = false;
         return var1;
      }

      public long eG() {
         return this.ir.getId();
      }
   }
}
