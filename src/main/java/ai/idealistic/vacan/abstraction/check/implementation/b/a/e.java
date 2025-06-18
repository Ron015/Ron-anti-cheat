package ai.idealistic.vacan.abstraction.check.implementation.b.a;

import ai.idealistic.vacan.abstraction.check.Check;
import ai.idealistic.vacan.functionality.server.MultiVersion;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class e extends ai.idealistic.vacan.abstraction.check.b {
   private static final boolean cF;
   private static final long cG;
   private static final double cH = 55.00000000000001D;
   private double cI;
   private long cJ;
   private long cK;
   private long cL;
   private int cM = 0;
   private int cN = 0;
   private final List<Long> cO = Collections.synchronizedList(new LinkedList());

   e(ai.idealistic.vacan.abstraction.check.e var1) {
      super(var1, (Check.DataType)null, Check.DetectionType.BUKKIT, "movement_spoof", true);
      if (cF) {
         this.cJ = Long.MAX_VALUE;
      }

   }

   void run() {
      this.a(() -> {
         if (cF) {
            long var1 = System.currentTimeMillis();
            double var3 = ai.idealistic.vacan.abstraction.g.b.b(this.ac.getLocation(), this.ac.cJ());
            if (var3 > (this.ac.cg() != null && this.cL < System.currentTimeMillis() ? 0.1D : ai.idealistic.vacan.utils.minecraft.entity.d.lj)) {
               long var5 = var1 - this.cJ;
               if (var5 >= 1000L) {
                  var5 = var1 - this.cK;
                  this.cK = var1;
                  this.b(var1);
                  if (var5 <= 1000L && this.cI != var3) {
                     this.cI = var3;
                     this.a("movement-spoof(default), distance: " + var3, this.ac.bM(), 0, true);
                  }
               }
            }
         }

      });
   }

   void R() {
      this.cL = System.currentTimeMillis() + 1000L;
   }

   private void b(long var1) {
      this.cJ = var1;
   }

   void V() {
      long var1 = System.currentTimeMillis();
      if (cF) {
         this.b(var1);
      }

      if ((double)this.cO.size() == 21.0D) {
         double var3 = 0.0D;
         double var5 = 0.0D;
         int var7 = 0;
         synchronized(this.cO) {
            Iterator var9 = this.cO.iterator();
            long var10 = (Long)var9.next();

            while(true) {
               if (var9.hasNext()) {
                  long var12 = (Long)var9.next();
                  if (var1 - var12 >= cG) {
                     var9.remove();
                     ++var7;
                     continue;
                  }

                  if (var7 <= 1) {
                     long var14 = var12 - var10;
                     var3 += (double)var14;
                     var5 += (double)(var14 * var14);
                     var10 = var12;
                     continue;
                  }
               }

               if (var7 == 0) {
                  this.cO.remove(0);
               }

               this.cO.add(var1);
               break;
            }
         }

         if (var7 <= 1) {
            var3 /= (double)(this.cO.size() - 1);
            if (var3 >= 55.00000000000001D) {
               var5 = Math.sqrt(var5 / (double)(this.cO.size() - 1));
               var5 = Math.abs(var3 - var5);
               if (var5 < 1.0D) {
                  ++this.cM;
                  if ((double)this.cM >= 20.0D) {
                     this.cM = 0;
                     ++this.cN;
                     this.a("movement-spoof(delay), average: " + var3 + ", deviation: " + var5, this.ac.bM(), 0, true);
                  }
               }
            } else {
               this.cM = 0;
               this.cN = 0;
            }
         } else {
            this.cM = 0;
            this.cN = 0;
         }
      } else {
         this.cM = 0;
         this.cN = 0;
         if (!this.cO.isEmpty()) {
            synchronized(this.cO) {
               Iterator var4 = this.cO.iterator();

               while(var4.hasNext()) {
                  long var22 = (Long)var4.next();
                  if (var1 - var22 < cG) {
                     break;
                  }

                  var4.remove();
               }

               this.cO.add(var1);
            }
         } else {
            synchronized(this.cO) {
               this.cO.add(var1);
            }
         }
      }

   }

   static {
      cF = MultiVersion.c(MultiVersion.MCVersion.V1_9);
      cG = (long)ai.idealistic.vacan.utils.b.a.B(20.0D) * 1000L;
   }
}
