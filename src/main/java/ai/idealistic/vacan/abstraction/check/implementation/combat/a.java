package ai.idealistic.vacan.abstraction.check.implementation.combat;

import ai.idealistic.vacan.abstraction.check.Check;
import ai.idealistic.vacan.abstraction.check.CheckEnums;
import ai.idealistic.vacan.utils.b.f;
import org.bukkit.potion.PotionEffectType;

public class a extends ai.idealistic.vacan.abstraction.check.e {
   private final ai.idealistic.vacan.abstraction.check.b aj = new ai.idealistic.vacan.abstraction.check.a.a(this, (Check.DataType)null, (Check.DetectionType)null, (String)null, true, 2000L, 30000L, 40000L, 60000L);

   public a(CheckEnums.HackType var1, ai.idealistic.vacan.abstraction.f.c var2) {
      super(var1, var2);
   }

   protected void a(boolean var1, Object var2) {
      if (var2 instanceof ai.idealistic.vacan.abstraction.d.e) {
         this.aj.a(() -> {
            double var1 = this.ac.getLocation().getY() - this.ac.bM().getY();
            if (!f.a(this.ac, this.ac.bO(), ai.idealistic.vacan.utils.minecraft.world.c.ns)) {
               if ((var1 < 0.079D || Math.abs(var1) == 0.0625D) && var1 > 0.0D && !this.ac.bI() && this.ac.bJ() && !(new ai.idealistic.vacan.abstraction.g.b(this.ac.getLocation())).dO().dz().isBlock() && !f.a(this.ac, this.ac.getLocation().clone().add(0.0D, 2.0D, 0.0D))) {
                  this.aj.c("packet");
               }

            }
         });
      }

   }

   protected boolean m() {
      return ai.idealistic.vacan.utils.minecraft.entity.b.F(this.ac) && !this.ac.dp().aX() && !this.ac.b(PotionEffectType.BLINDNESS, 0L);
   }
}
