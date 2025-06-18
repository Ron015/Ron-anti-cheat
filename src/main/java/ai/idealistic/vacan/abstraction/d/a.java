package ai.idealistic.vacan.abstraction.d;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;

public class a implements Cancellable {
   private boolean cancelled;
   public final Block fu;
   public final Block fv;
   public final Player fd;

   public a(Player var1, Block var2, Block var3, boolean var4) {
      this.fd = var1;
      this.fv = var3;
      this.fu = var2;
      this.cancelled = var4;
   }

   public boolean isCancelled() {
      return this.cancelled;
   }

   public void setCancelled(boolean var1) {
      this.cancelled = var1;
   }
}
