package ai.idealistic.vacan.abstraction.d;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;

public class i implements Cancellable {
   public final Player fd;
   public final LivingEntity fz;
   private boolean cancelled;

   public i(Player var1, LivingEntity var2, boolean var3) {
      this.fd = var1;
      this.fz = var2;
      this.cancelled = var3;
   }

   public boolean isCancelled() {
      return this.cancelled;
   }

   public void setCancelled(boolean var1) {
      this.cancelled = var1;
   }
}
