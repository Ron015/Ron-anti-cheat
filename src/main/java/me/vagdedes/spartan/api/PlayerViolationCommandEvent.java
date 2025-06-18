package me.vagdedes.spartan.api;

import ai.idealistic.vacan.abstraction.check.CheckEnums;
import lombok.Generated;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerViolationCommandEvent extends Event implements Cancellable {
   private final Player p;
   private final CheckEnums.HackType h;
   private final String c;
   private boolean cancelled;
   private static final HandlerList handlers = new HandlerList();

   public PlayerViolationCommandEvent(Player var1, CheckEnums.HackType var2, String var3) {
      this.p = var1;
      this.h = var2;
      this.c = var3;
      this.cancelled = false;
   }

   public Player getPlayer() {
      return this.p;
   }

   public CheckEnums.HackType getHackType() {
      return this.h;
   }

   public String getCommand() {
      return this.c;
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
