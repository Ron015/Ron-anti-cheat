package ai.idealistic.vacan.abstraction.f;

import org.bukkit.potion.PotionEffect;

public class b {
   public final PotionEffect gf;
   private final long t;

   public b(PotionEffect var1) {
      this.gf = var1;
      this.t = System.currentTimeMillis() + (long)var1.getDuration() * 50L;
   }

   public long bA() {
      long var1 = this.t - System.currentTimeMillis();
      return var1 >= 0L ? 0L : Math.abs(var1);
   }

   public boolean bB() {
      return this.t - System.currentTimeMillis() >= 0L;
   }
}
