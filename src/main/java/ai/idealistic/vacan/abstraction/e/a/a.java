package ai.idealistic.vacan.abstraction.e.a;

import ai.idealistic.vacan.abstraction.check.Check;
import ai.idealistic.vacan.abstraction.check.CheckEnums;
import ai.idealistic.vacan.abstraction.f.c;
import ai.idealistic.vacan.api.Permission;
import ai.idealistic.vacan.functionality.connection.e;
import ai.idealistic.vacan.functionality.server.MultiVersion;
import ai.idealistic.vacan.utils.minecraft.a.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.bukkit.Material;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

public class a extends ai.idealistic.vacan.abstraction.e.a {
   public a() {
      super("Manage Checks", 54, (Permission)Permission.MANAGE);
   }

   public boolean b(c var1, boolean var2, Object var3) {
      CheckEnums.HackType[] var4 = CheckEnums.HackType.values();
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         CheckEnums.HackType var7 = var4[var6];
         this.a(var1, var7);
      }

      this.a("§cDisable silent checking for all checks", (List)null, new ItemStack(d.au("lead")), 46);
      this.a("§cDisable all checks", (List)null, new ItemStack(MultiVersion.c(MultiVersion.MCVersion.V1_13) ? Material.RED_TERRACOTTA : Material.getMaterial("STAINED_CLAY"), 1, (short)14), 47);
      this.a("§4Back", (List)null, new ItemStack(Material.ARROW), 49);
      this.a("§aEnable all checks", (List)null, new ItemStack(MultiVersion.c(MultiVersion.MCVersion.V1_13) ? Material.LIME_TERRACOTTA : Material.getMaterial("STAINED_CLAY"), 1, (short)5), 51);
      this.a("§aEnable silent checking for all checks", (List)null, new ItemStack(Material.FEATHER), 52);
      return true;
   }

   public boolean f(c var1) {
      String var2 = this.fI.getItemMeta().getDisplayName();
      var2 = var2.startsWith("§") ? var2.substring(2) : var2;
      if (var2.equals("Back")) {
         ai.idealistic.vacan.functionality.server.c.jm.a(var1, var1.bC().getName());
      } else if (var2.equals("Disable all checks")) {
         ai.idealistic.vacan.functionality.server.a.eV();
         this.e(var1);
      } else if (var2.equals("Enable all checks")) {
         ai.idealistic.vacan.functionality.server.a.eU();
         this.e(var1);
      } else if (var2.equals("Disable silent checking for all checks")) {
         ai.idealistic.vacan.functionality.server.a.eX();
         this.e(var1);
      } else if (var2.equals("Enable silent checking for all checks")) {
         ai.idealistic.vacan.functionality.server.a.eW();
         this.e(var1);
      } else {
         var2 = var2.split(" ")[0];
         Check var3;
         if (this.fJ == ClickType.LEFT) {
            var3 = ai.idealistic.vacan.functionality.server.a.O(var2);
            if (var3 != null) {
               var3.a((Check.DataType)null, !var3.a((Check.DataType)null, (String)null));
            }

            this.e(var1);
         } else if (this.fJ == ClickType.RIGHT) {
            var3 = ai.idealistic.vacan.functionality.server.a.O(var2);
            if (var3 != null) {
               var3.b((Check.DataType)null, !var3.b((Check.DataType)null, (String)null));
            }

            this.e(var1);
         } else if (this.fJ.isShiftClick()) {
            var3 = ai.idealistic.vacan.functionality.server.a.O(var2);
            if (var3 != null) {
               ai.idealistic.vacan.functionality.d.d.b(var3.hackType);
               var1.bC().closeInventory();
               ai.idealistic.vacan.functionality.c.a.b.b(var1.bC(), ai.idealistic.vacan.functionality.server.a.jb.m("check_stored_data_delete_message").replace("{check}", var3.getName()), "Click to receive plugin support.", "https://www.idealistic.ai/discord/vacan");
            }
         } else if (this.fJ.isKeyboardClick()) {
            var3 = ai.idealistic.vacan.functionality.server.a.O(var2);
            if (var3 != null) {
               var3.c((Check.DataType)null, !var3.a((Check.DataType)null));
            }

            this.e(var1);
         }
      }

      return true;
   }

   private void a(c var1, CheckEnums.HackType var2) {
      Check var3 = var2.getCheck();
      boolean var4 = var3.a((Check.DataType)null, (String)null);
      boolean var5 = var3.b((Check.DataType)null, (String)null);
      boolean var6 = ai.idealistic.vacan.functionality.server.b.isBypassing(var1.bC(), var2);
      boolean var7 = var3.a((Check.DataType)null);
      boolean var8 = e.a(Check.DataType.JAVA, var2.category);
      boolean var9 = e.a(Check.DataType.BEDROCK, var2.category);
      String var11;
      if (var5) {
         var11 = "§7Right click to §cdisable §7silent checking.";
      } else {
         var11 = "§7Right click to §aenable §7silent checking.";
      }

      String var12;
      if (var7) {
         var12 = "§7Keyboard click to §cdisable §7punishments.";
      } else {
         var12 = "§7Keyboard click to §aenable §7punishments.";
      }

      String var10;
      String var13;
      String var14;
      ItemStack var15;
      if (var4) {
         var15 = new ItemStack(MultiVersion.c(MultiVersion.MCVersion.V1_13) ? Material.LIME_DYE : Material.getMaterial("INK_SACK"), 1, (short)10);
         var13 = "§2";
         var14 = "§a";
         var10 = "§7Left click to §cdisable §7check.";
      } else {
         var15 = new ItemStack(MultiVersion.c(MultiVersion.MCVersion.V1_13) ? Material.GRAY_DYE : Material.getMaterial("INK_SACK"), 1, (short)8);
         var13 = "§4";
         var14 = "§c";
         var10 = "§7Left click to §aenable §7check.";
      }

      ArrayList var16 = new ArrayList(30);
      String[] var17 = var2.description;
      int var18 = var17.length;

      String var20;
      for(int var19 = 0; var19 < var18; ++var19) {
         var20 = var17[var19];
         var16.add("§7" + var20);
      }

      var16.add("");
      var16.add((var8 ? "§2" : "§4") + "Java Edition §8/ " + (var9 ? "§2" : "§4") + "Bedrock Edition");
      var16.add((var4 ? "§a" : "§c") + "Enabled §8/ " + (var5 ? "§a" : "§c") + "Silent §8/ " + (var7 ? "§a" : "§c") + "Punishments §8/ " + (var6 ? "§a" : "§c") + "Bypassing");
      int var21 = 0;
      Iterator var22 = var3.b().iterator();

      while(var22.hasNext()) {
         String var23 = (String)var22.next();
         if (var23 != null) {
            ++var21;
            var20 = "§7" + var21 + "§8:§f ";
            if (var23.length() > 40) {
               var16.add(var20 + var23.substring(0, 40));
            } else {
               var16.add(var20 + var23);
            }
         }
      }

      var16.add("");
      var16.add(var10);
      var16.add(var11);
      var16.add(var12);
      var16.add("§7Shift click to §edelete §7the check's data.");
      if (var4 && var5) {
         var15.addUnsafeEnchantment(ai.idealistic.vacan.utils.minecraft.a.b.lI, 1);
      }

      this.a(var13 + var3.getName() + " " + var14 + var2.category.toString() + " Check", var16, var15, -1);
   }
}
