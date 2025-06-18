package ai.idealistic.vacan.abstraction.check.implementation.combat.killaura;

import ai.idealistic.vacan.abstraction.check.Check;

public class b extends ai.idealistic.vacan.abstraction.check.b {
   private int aE = 0;
   private int aX = 0;
   private int aY = 0;
   private int aZ = 0;
   private int ba = 0;
   private int bb = 0;
   private long bc = 0L;
   private long bd = 0L;

   b(ai.idealistic.vacan.abstraction.check.e var1) {
      super(var1, (Check.DataType)null, Check.DetectionType.PACKETS, "hit_time", true, 2000L, 30000L, 40000L, 60000L);
   }

   void run() {
      this.a(() -> {
         long var1 = System.currentTimeMillis() - this.bc;
         int var3 = (int)Math.abs(var1 - this.bd);
         this.aZ += var3;
         ++this.ba;
         if (this.ac.bS() <= 1000) {
            if (var3 < 5 && var3 != 0) {
               ++this.bb;
            }

            if (var1 == 0L) {
               this.aY = 2;
            }

            if (this.aY > 1) {
               this.aE += 55;
               if (this.aE >= 300) {
                  this.a("switch", this.ac.bM());
               }
            }

            if (this.ba >= 5 && ai.idealistic.vacan.listeners.protocol.b.d.n(this.ac.ci()) < 2) {
               if (this.aZ < 35) {
                  this.aX += this.aZ < 10 ? 150 : 75;
                  if (this.aX >= 300) {
                     this.a("post(linear-analysis)", this.ac.bM());
                  }
               } else if (this.aZ > 45 && this.aZ < 55) {
                  this.aX += 150;
                  if (this.aX >= 300) {
                     this.a("post(default)", this.ac.bM());
                  }
               } else if (this.bb >= 3) {
                  this.aX += 100;
                  if (this.aX >= 300) {
                     this.a("post(low)", this.ac.bM());
                  }
               } else if (this.aX > 0) {
                  this.aX -= 50;
               }

               this.ba = 0;
               this.aZ = 0;
               this.bb = 0;
            }

            if (this.aE > 0) {
               this.aE -= 5;
            }

            if (this.aY > 0) {
               --this.aY;
            }

            this.bc = System.currentTimeMillis();
            this.bd = var1;
         }
      });
   }
}
