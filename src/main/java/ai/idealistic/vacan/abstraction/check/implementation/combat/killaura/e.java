package ai.idealistic.vacan.abstraction.check.implementation.combat.killaura;

import ai.idealistic.vacan.abstraction.check.CheckEnums;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerMoveEvent;

public class e extends ai.idealistic.vacan.abstraction.check.e {
   private final c bo = new c(this);
   private final b bp = new b(this);
   private final ai.idealistic.vacan.abstraction.check.implementation.combat.killaura.movedirection.c bq = new ai.idealistic.vacan.abstraction.check.implementation.combat.killaura.movedirection.c(this);
   private final d br = new d(this);
   private final a bs = new a(this);

   public e(CheckEnums.HackType var1, ai.idealistic.vacan.abstraction.f.c var2) {
      super(var1, var2);
   }

   boolean a(LivingEntity var1) {
      return ai.idealistic.vacan.compatibility.b.a.b.g(var1) == null && ai.idealistic.vacan.utils.minecraft.entity.b.b(this.ac, var1) && !this.ac.bC().equals(var1) && this.hackType.getCheck().a("detection." + (var1 instanceof Player ? "players" : "entities"), true);
   }

   protected void a(boolean var1, Object var2) {
      if (var2 instanceof PlayerMoveEvent) {
         this.bq.run();
         this.br.run();
      } else if (var2 instanceof ai.idealistic.vacan.abstraction.d.e) {
         ai.idealistic.vacan.abstraction.d.e var3 = (ai.idealistic.vacan.abstraction.d.e)var2;
         LivingEntity var4 = var3.fz;
         if (this.a(var4)) {
            this.bo.run();
            this.bq.a((Entity)var4);
            this.bp.run();
            this.br.z();
            this.bs.a(var3);
         }
      } else if (var2 instanceof ai.idealistic.vacan.abstraction.d.d) {
         this.br.A();
      }

   }

   protected boolean m() {
      return ai.idealistic.vacan.utils.minecraft.entity.b.F(this.ac);
   }
}
