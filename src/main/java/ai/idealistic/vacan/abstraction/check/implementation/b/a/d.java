package ai.idealistic.vacan.abstraction.check.implementation.b.a;

import ai.idealistic.vacan.abstraction.check.Check;

public class d extends ai.idealistic.vacan.abstraction.check.b {
   d(ai.idealistic.vacan.abstraction.check.e var1) {
      super(var1, (Check.DataType)null, (Check.DetectionType)null, "head_position", true);
   }

   void run() {
      this.a(() -> {
         if (!this.ac.bY() && this.ac.cg() == null && !this.ac.cq()) {
            double var1 = (double)this.ac.getLocation().getPitch();
            if (Math.abs(var1) >= 90.0999984741211D) {
               this.c("head-position, pitch: " + var1);
            }

         }
      });
   }
}
