package ai.idealistic.vacan.abstraction.e.a;

import ai.idealistic.vacan.abstraction.b.c;
import ai.idealistic.vacan.abstraction.check.Check;
import ai.idealistic.vacan.abstraction.check.CheckEnums;
import ai.idealistic.vacan.api.Permission;
import ai.idealistic.vacan.compatibility.Compatibility;
import ai.idealistic.vacan.functionality.connection.e;
import ai.idealistic.vacan.functionality.d.d;
import ai.idealistic.vacan.functionality.server.MultiVersion;
import ai.idealistic.vacan.utils.a.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

public class b extends ai.idealistic.vacan.abstraction.e.a {
   private static final c fN = new c(new ai.idealistic.vacan.utils.a.c(new ConcurrentHashMap(), 512));
   private static final String fO = "Player Info: ";
   private static final int[] fP = new int[]{20, 21, 23, 24};

   public b() {
      super("Player Info: ", 45, (Permission[])(new Permission[]{Permission.MANAGE, Permission.INFO}));
   }

   public boolean b(ai.idealistic.vacan.abstraction.f.c var1, boolean var2, Object var3) {
      ai.idealistic.vacan.abstraction.f.c var4 = ai.idealistic.vacan.functionality.server.c.Q(var3.toString());
      boolean var5 = var4 != null;
      ai.idealistic.vacan.abstraction.profiling.a var6 = var5 ? var4.bU() : d.U(var3.toString());
      if (var6 == null) {
         var1.bC().closeInventory();
         ai.idealistic.vacan.functionality.c.a.b.b(var1.bC(), ai.idealistic.vacan.functionality.server.a.jb.m("player_not_found_message"), "Click to receive plugin support.", "https://www.idealistic.ai/discord/vacan");
         return false;
      } else {
         this.a(var1, "Player Info: " + (var5 ? var4.bC().getName() : var6.name));
         ArrayList var7 = new ArrayList();
         var7.add("");
         if (var5) {
            var7.add("§7Version§8:§c " + var4.gG.toString());
            var7.add("§7Latency§8:§c " + var4.bS() + "ms");
            var7.add("§7Edition§8:§c " + var4.dr());
         } else {
            var7.add("§7Last Known Edition§8:§c " + var6.bv());
         }

         long var8 = var6.bw().by();
         if (var8 > 0L) {
            var7.add("§7Total Active Time§8:§c " + h.t(var8));
         }

         var7.add("");
         var7.add("§cClick to delete the player's stored data.");
         this.a("§c" + var6.name, var7, var6.bu(), 4);
         CheckEnums.HackCategoryType[] var10 = CheckEnums.HackCategoryType.values();
         int var11 = var10.length;

         for(int var12 = 0; var12 < var11; ++var12) {
            CheckEnums.HackCategoryType var13 = var10[var12];
            this.a(fP[var13.ordinal()], var5, var4, var6, var7, var13);
         }

         var7.clear();
         var7.add("");
         var7.add("§7Packets§8: §a" + (ai.idealistic.vacan.functionality.server.c.bW() ? "Enabled" : "Disabled"));
         var7.add("§7Checks Available§8: " + (e.j(Check.DataType.JAVA) ? "§a" : "§c") + Check.DataType.JAVA + " §8/ " + (e.j(Check.DataType.BEDROCK) ? "§a" : "§c") + Check.DataType.BEDROCK);
         Runtime var17 = Runtime.getRuntime();
         var7.add("§7Server Version§8: §a" + MultiVersion.jf.toString());
         long var18 = var17.maxMemory();
         var7.add("§7Server Memory Usage§8: §a" + ai.idealistic.vacan.utils.b.a.e((double)(var18 - var17.freeMemory()) / (double)var18 * 100.0D, 2.0D) + "%");
         var7.add("");
         var7.add("§7Click to §amanage checks§7.");
         this.a("§aManagement", var7, new ItemStack(ai.idealistic.vacan.utils.minecraft.a.d.au("crafting_table")), 39);
         this.a("§cClose", (List)null, new ItemStack(Material.ARROW), 40);
         List var19 = ai.idealistic.vacan.functionality.server.a.jc.ea();
         int var14 = var19.size();
         var7.clear();
         var7.add("");
         var7.add("§7Identified§8:§a " + var14);
         var7.add("§7Total§8:§a " + ai.idealistic.vacan.functionality.server.a.jc.eb().size());
         if (var14 > 0) {
            var7.add("");
            var7.add("§7Compatibilities§8:");
            Iterator var15 = var19.iterator();

            while(var15.hasNext()) {
               Compatibility.CompatibilityType var16 = (Compatibility.CompatibilityType)var15.next();
               var7.add("§a" + var16.toString());
            }
         }

         this.a("§aCompatibilities", var7, new ItemStack(ai.idealistic.vacan.utils.minecraft.a.d.au("enchanting_table")), 41);
         return true;
      }
   }

   private void a(int var1, boolean var2, ai.idealistic.vacan.abstraction.f.c var3, ai.idealistic.vacan.abstraction.profiling.a var4, List<String> var5, CheckEnums.HackCategoryType var6) {
      var5.clear();
      ItemStack var7 = new ItemStack(var6.material);
      boolean var8 = false;
      CheckEnums.HackType[] var9 = CheckEnums.HackType.values();
      int var10 = var9.length;

      for(int var11 = 0; var11 < var10; ++var11) {
         CheckEnums.HackType var12 = var9[var11];
         if (var12.category == var6) {
            String var13 = this.a(var3, var12, var4.bv(), var2);
            if (var13 != null) {
               if (!var8) {
                  var8 = true;
                  var5.add("");
               }

               var5.add("§7" + var12.getCheck().getName() + "§8:§f " + var13);
            } else {
               List var14 = var3.a(var12).o();
               if (!var14.isEmpty()) {
                  if (!var8) {
                     var8 = true;
                     var5.add("");
                  }

                  var5.add("§4" + var12.getCheck().getName() + "§8: §c" + var14.size() + (var14.size() == 1 ? " suspicion" : " suspicions"));
               }
            }
         }
      }

      if (!var8) {
         var5.add("");
         var5.add("§7No useful information currently available.");
      }

      this.a("§2" + var6 + " checks", var5, var7, var1);
   }

   private String a(ai.idealistic.vacan.abstraction.f.c var1, CheckEnums.HackType var2, Check.DataType var3, boolean var4) {
      if (!var4) {
         return "Player is offline";
      } else if (!e.a(var3, var2.category)) {
         return "Check is not installed";
      } else {
         String var5 = var1.bV().getName();
         Check var6 = var2.getCheck();
         if (!var6.a(var3, var5)) {
            return "Check is disabled";
         } else {
            ai.idealistic.vacan.abstraction.check.a var7 = var1.a(var2).p();
            return ai.idealistic.vacan.functionality.server.b.isBypassing(var1.bC(), var2) ? "Player has permission bypass" : (var7 != null ? "Custom: " + var7.d() : null);
         }
      }
   }

   public void z(String var1) {
      Collection var2 = ai.idealistic.vacan.functionality.server.c.fc();
      if (!var2.isEmpty()) {
         Iterator var3 = var2.iterator();

         while(var3.hasNext()) {
            ai.idealistic.vacan.abstraction.f.c var4 = (ai.idealistic.vacan.abstraction.f.c)var3.next();
            InventoryView var5 = var4.bC().getOpenInventory();
            if (var5.getTitle().equals("Player Info: " + var1) && fN.t("player-info=" + var4.bT())) {
               fN.g("player-info=" + var4.bT(), 1);
               ai.idealistic.vacan.functionality.server.c.jm.a(var4, var1);
            }
         }
      }

   }

   public boolean f(ai.idealistic.vacan.abstraction.f.c var1) {
      String var2 = this.fI.getItemMeta().getDisplayName();
      var2 = var2.startsWith("§") ? var2.substring(2) : var2;
      String var3 = this.fG.substring("Player Info: ".length());
      if (var2.equalsIgnoreCase(var3)) {
         if (!ai.idealistic.vacan.functionality.server.b.a(var1.bC(), Permission.MANAGE)) {
            var1.bC().closeInventory();
            ai.idealistic.vacan.functionality.c.a.b.b(var1.bC(), ai.idealistic.vacan.functionality.server.a.jb.m("no_permission"), "Click to receive plugin support.", "https://www.idealistic.ai/discord/vacan");
         } else {
            String var4 = Bukkit.getOfflinePlayer(var3).getName();
            if (var4 == null) {
               ai.idealistic.vacan.functionality.c.a.b.b(var1.bC(), ai.idealistic.vacan.functionality.server.a.jb.m("player_not_found_message"), "Click to receive plugin support.", "https://www.idealistic.ai/discord/vacan");
            } else {
               d.V(var4);
               var1.bC().sendMessage(ai.idealistic.vacan.functionality.server.a.jb.m("player_stored_data_delete_message").replace("{player}", var4));
            }

            var1.bC().closeInventory();
         }
      } else if (var2.equals("Close")) {
         var1.bC().closeInventory();
      } else if (var2.equals("Management")) {
         if (!ai.idealistic.vacan.functionality.server.b.a(var1.bC(), Permission.MANAGE)) {
            var1.bC().closeInventory();
            ai.idealistic.vacan.functionality.c.a.b.b(var1.bC(), ai.idealistic.vacan.functionality.server.a.jb.m("no_permission"), "Click to receive plugin support.", "https://www.idealistic.ai/discord/vacan");
         } else {
            ai.idealistic.vacan.functionality.server.c.jl.e(var1);
         }
      }

      return true;
   }
}
