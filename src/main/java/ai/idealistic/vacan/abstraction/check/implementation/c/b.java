package ai.idealistic.vacan.abstraction.check.implementation.c;

import ai.idealistic.vacan.abstraction.check.Check;
import ai.idealistic.vacan.abstraction.check.CheckEnums;
import ai.idealistic.vacan.compatibility.Compatibility;
import ai.idealistic.vacan.compatibility.a.b.f;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

public class b extends ai.idealistic.vacan.abstraction.check.e {
   private final ai.idealistic.vacan.abstraction.check.b eh = new ai.idealistic.vacan.abstraction.check.a.a(this, (Check.DataType)null, (Check.DetectionType)null, "delay", true);
   private final ai.idealistic.vacan.abstraction.check.b ei = new ai.idealistic.vacan.abstraction.check.a.a(this, (Check.DataType)null, (Check.DetectionType)null, "breaks_per_second", (Boolean)null);
   private final ai.idealistic.vacan.abstraction.check.b ej = new ai.idealistic.vacan.abstraction.check.a.a(this, (Check.DataType)null, (Check.DetectionType)null, "indirect_surroundings_per_second", (Boolean)null);
   private Block ek = null;
   private final Map<Integer, Long> el = new ConcurrentHashMap(2);
   private final ai.idealistic.vacan.abstraction.b.a.a em = new ai.idealistic.vacan.abstraction.b.a.a();
   private final ai.idealistic.vacan.abstraction.b.a.a en = new ai.idealistic.vacan.abstraction.b.a.a();

   public b(CheckEnums.HackType var1, ai.idealistic.vacan.abstraction.f.c var2) {
      super(var1, var2);
   }

   private void a(Block var1, int var2) {
      this.eh.a(() -> {
         if (!ai.idealistic.vacan.utils.minecraft.world.c.aa(var1.getType())) {
            GameMode var3 = this.ac.cl();
            if (var3 == GameMode.SURVIVAL || var3 == GameMode.ADVENTURE) {
               long var4 = (Long)this.el.getOrDefault(Objects.hash(new Object[]{var1.getWorld().getName(), var1.getType(), var1.getX(), var1.getY(), var1.getZ()}), 0L);
               if (var4 > 0L) {
                  var4 = System.currentTimeMillis() - var4;
                  if (var4 > 0L) {
                     ItemStack var6 = this.ac.getItemInHand();
                     long var7 = ai.idealistic.vacan.utils.minecraft.a.d.a(this.ac, var6, var1.getType());
                     if (var7 > -1L) {
                        long var9 = var7 / 2L;
                        if (var1.getY() <= this.ac.getLocation().getBlockY() && (double)Math.abs(var1.getX() - this.ac.getLocation().getBlockX()) <= 1.5D && (double)Math.abs(var1.getZ() - this.ac.getLocation().getBlockZ()) <= 1.5D) {
                           var9 /= 2L;
                        }

                        if (var9 > 100L && var4 < var9) {
                           boolean var11 = var6 == null;
                           Collection var12 = this.ac.ck();
                           Object var13 = !var11 ? var6.getEnchantments().entrySet() : new HashSet(0);
                           StringBuilder var14 = new StringBuilder();
                           StringBuilder var15 = new StringBuilder();
                           Iterator var16;
                           String var18;
                           if (!((Set)var13).isEmpty()) {
                              var16 = ((Set)var13).iterator();

                              while(var16.hasNext()) {
                                 Entry var17 = (Entry)var16.next();
                                 var18 = ((Enchantment)var17.getKey()).getName().toLowerCase().replace("_", "/");
                                 var14.append(var18).append("-").append(var17.getValue()).append(", ");
                              }

                              var14 = new StringBuilder(var14.substring(0, var14.length() - 2));
                           }

                           if (!var12.isEmpty()) {
                              var16 = var12.iterator();

                              while(var16.hasNext()) {
                                 PotionEffect var20 = (PotionEffect)var16.next();
                                 var18 = var20.getType().getName().toLowerCase().replace("_", "/");
                                 var15.append(var18).append("-").append(var20.getAmplifier() + 1).append(", ");
                              }

                              var15 = new StringBuilder(var15.substring(0, var15.length() - 2));
                           }

                           String var19 = "delay, time: " + var4 + ", original-limit: " + var7 + ", limit: " + var9 + ", difference: " + (var9 - var4) + ", block: " + ai.idealistic.vacan.utils.minecraft.world.c.ae(var1.getType()) + ", item: " + (var11 ? "none" : ai.idealistic.vacan.utils.minecraft.world.c.ae(var6.getType())) + ", enchantments: " + (((Set)var13).isEmpty() ? "none" : "[" + var14 + "]") + ", effects: " + (var12.isEmpty() ? "none" : "[" + var15 + "]");
                           this.eh.a(var19, (Location)null, var2);
                        }
                     }
                  }
               }
            }
         }

      });
   }

   private void a(int var1, Block var2) {
      this.ei.a(() -> {
         GameMode var3 = this.ac.cl();
         if (var3 == GameMode.CREATIVE) {
            int var4 = this.hackType.getCheck().a("max_breaks_per_second", 40);
            if (var4 > 0) {
               double var5 = this.em.a(1.0D, 20);
               if (var5 >= (double)var4) {
                  this.ei.a("breaks-per-second, type: " + ai.idealistic.vacan.utils.minecraft.world.c.i(var2) + ", limit: " + var4, (Location)null, var1);
               }
            }
         }

      });
   }

   private void b(int var1, Block var2) {
      this.ej.a(() -> {
         GameMode var3 = this.ac.cl();
         if ((var3 == GameMode.SURVIVAL || var3 == GameMode.ADVENTURE) && !ai.idealistic.vacan.utils.minecraft.world.c.a(this.ac, var2.getType())) {
            int var4 = ai.idealistic.vacan.utils.b.a.B(20.0D);
            int var5 = this.hackType.getCheck().a("indirect_surroundings_per_second", ai.idealistic.vacan.utils.b.a.A((double)var4 * 0.75D));
            if (var5 > 0) {
               double var6;
               if (this.ek != null) {
                  if (var2.getX() == this.ek.getX() && var2.getY() == this.ek.getY() && var2.getZ() == this.ek.getZ() || var2.getX() == this.ek.getX() + 1 && var2.getY() == this.ek.getY() && var2.getZ() == this.ek.getZ() || var2.getX() == this.ek.getX() - 1 && var2.getY() == this.ek.getY() && var2.getZ() == this.ek.getZ() || var2.getX() == this.ek.getX() && var2.getY() == this.ek.getY() && var2.getZ() == this.ek.getZ() + 1 || var2.getX() == this.ek.getX() && var2.getY() == this.ek.getY() && var2.getZ() == this.ek.getZ() - 1 || var2.getX() == this.ek.getX() + 1 && var2.getY() == this.ek.getY() && var2.getZ() == this.ek.getZ() + 1 || var2.getX() == this.ek.getX() - 1 && var2.getY() == this.ek.getY() && var2.getZ() == this.ek.getZ() - 1 || var2.getX() == this.ek.getX() + 1 && var2.getY() == this.ek.getY() && var2.getZ() == this.ek.getZ() - 1 || var2.getX() == this.ek.getX() - 1 && var2.getY() == this.ek.getY() && var2.getZ() == this.ek.getZ() + 1 || var2.getX() == this.ek.getX() && var2.getY() == this.ek.getY() + 1 && var2.getZ() == this.ek.getZ() || var2.getX() == this.ek.getX() && var2.getY() == this.ek.getY() - 1 && var2.getZ() == this.ek.getZ()) {
                     return;
                  }

                  var6 = this.en.a(1.0D, var4);
               } else {
                  var6 = this.en.a(1.0D, var4);
               }

               if (var6 >= (double)var5) {
                  String var8 = "indirect-surroundings-per-second, type: " + ai.idealistic.vacan.utils.minecraft.world.c.i(var2) + ", limit: " + var5;
                  this.ej.a(var8, (Location)null, var1);
               }

               this.ek = var2;
            }
         }

      });
   }

   protected void a(boolean var1, Object var2) {
      Block var4;
      if (var2 instanceof PlayerInteractEvent) {
         PlayerInteractEvent var3 = (PlayerInteractEvent)var2;
         if (var3.getAction() == Action.LEFT_CLICK_BLOCK) {
            var4 = var3.getClickedBlock();
            if (var4 != null && !ai.idealistic.vacan.compatibility.a.a.d.e(var4)) {
               if ((double)this.el.size() == 20.0D) {
                  Iterator var5 = this.el.keySet().iterator();
                  var5.next();
                  var5.remove();
               }

               this.el.put(Objects.hash(new Object[]{var4.getWorld().getName(), var4.getType(), var4.getX(), var4.getY(), var4.getZ()}), System.currentTimeMillis());
            }
         }
      } else if (var2 instanceof BlockBreakEvent) {
         BlockBreakEvent var6 = (BlockBreakEvent)var2;
         var4 = var6.getBlock();
         if (!f.f(var4) && !ai.idealistic.vacan.compatibility.a.a.d.e(var4)) {
            int var7 = ai.idealistic.vacan.utils.b.a.B(20.0D);
            this.a(var4, var7);
            this.a(var7, var4);
            this.b(var7, var4);
            if (this.j()) {
               var6.setCancelled(true);
            }
         }
      }

   }

   protected boolean m() {
      return !ai.idealistic.vacan.compatibility.a.b.a.i(this.ac) && !ai.idealistic.vacan.compatibility.a.e.b.d(this.ac, "drill") && !ai.idealistic.vacan.compatibility.a.b.e.i(this.ac) && !ai.idealistic.vacan.compatibility.a.a.b.i(this.ac) && !Compatibility.CompatibilityType.CRAFT_BOOK.isFunctional() && !Compatibility.CompatibilityType.ADVANCED_ENCHANTMENTS.isFunctional() && ai.idealistic.vacan.compatibility.a.f.a.e(this.ac, "PLAYER_BLOCK_BREAK_SPEED") == Double.MIN_VALUE;
   }
}
