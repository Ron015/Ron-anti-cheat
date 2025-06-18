package ai.idealistic.vacan.abstraction.check.implementation.b.a;

import ai.idealistic.vacan.abstraction.check.Check;
import org.bukkit.GameMode;

public class b extends ai.idealistic.vacan.abstraction.check.b {
   private final ai.idealistic.vacan.abstraction.b.a.a bk = new ai.idealistic.vacan.abstraction.b.a.a();

   b(ai.idealistic.vacan.abstraction.check.e var1) {
      super(var1, Check.DataType.JAVA, (Check.DetectionType)null, "food_sprint", true);
   }

   void run() {
      this.a(() -> {
         if (this.ac.bK() && !this.ac.cq()) {
            GameMode var1 = this.ac.cl();
            int var2 = this.ac.bC().getFoodLevel();
            byte var3 = 6;
            if (var2 <= var3 && (var1 == GameMode.SURVIVAL || var1 == GameMode.ADVENTURE)) {
               double var4 = this.bk.a(1.0D, 10) / 10.0D;
               if (var4 >= 0.4D) {
                  this.a("food-sprint, game-mode: " + var1.toString().toLowerCase().replace("_", "-") + ", food: " + var2, this.ac.bM(), 0, true);
               }
            }
         }

      });
   }
}
