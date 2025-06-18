package ai.idealistic.vacan.api;

import lombok.Generated;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerFoundOreEvent extends Event implements Cancellable {
   private final Player p;
   private final String me;
   private final Location l;
   private final Material ma;
   private boolean cancelled;
   private static final HandlerList handlers = new HandlerList();

   public PlayerFoundOreEvent(Player var1, String var2, Location var3, Material var4) {
      this.p = var1;
      this.me = var2;
      this.l = var3;
      this.ma = var4;
      this.cancelled = false;
      me.vagdedes.spartan.api.PlayerFoundOreEvent var5 = new me.vagdedes.spartan.api.PlayerFoundOreEvent(var1, var2, var3, var4);
      var5.setCancelled(this.isCancelled());
      Bukkit.getPluginManager().callEvent(var5);
   }

   public Player getPlayer() {
      return this.p;
   }

   public String getMessage() {
      return this.me;
   }

   public Location getLocation() {
      return this.l;
   }

   public Material getMaterial() {
      return this.ma;
   }

   public HandlerList getHandlers() {
      return handlers;
   }

   public static HandlerList getHandlerList() {
      return handlers;
   }

   @Generated
   public void setCancelled(boolean var1) {
      this.cancelled = var1;
   }

   @Generated
   public boolean isCancelled() {
      return this.cancelled;
   }
}
