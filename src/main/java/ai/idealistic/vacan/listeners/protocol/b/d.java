package ai.idealistic.vacan.listeners.protocol.b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.bukkit.Location;

public class d {
   private static final Map<Integer, LinkedList<Location>> jX = new ai.idealistic.vacan.utils.a.c(new ConcurrentHashMap(), 1024);
   private static final Map<Integer, Long> jY = new ai.idealistic.vacan.utils.a.c(new ConcurrentHashMap(), 1024);
   private static final Map<Integer, List<Integer>> jZ = new ai.idealistic.vacan.utils.a.c(new ConcurrentHashMap(), 1024);

   public static void a(int var0, Location var1) {
      ((LinkedList)jX.computeIfAbsent(var0, (var0x) -> {
         return new LinkedList();
      })).addFirst(var1);
      List var2 = (List)jZ.computeIfAbsent(var0, (var0x) -> {
         return Collections.synchronizedList(new LinkedList());
      });
      var2.add((int)(System.currentTimeMillis() - (Long)jY.getOrDefault(var0, System.currentTimeMillis())));
      jY.put(var0, System.currentTimeMillis());
      m(var0);
      if (var2.size() == 10) {
         List var3 = Collections.synchronizedList(new LinkedList());
         var3.add((Integer)Collections.max(var2) / 2);
         jZ.put(var0, var3);
      }

   }

   public static void m(int var0) {
      jY.put(var0, System.currentTimeMillis());
   }

   public static Location d(int var0, int var1) {
      LinkedList var2 = (LinkedList)jX.get(var0);
      return var2 != null && !var2.isEmpty() ? (Location)var2.get(var1 >= var2.size() ? var2.size() - 1 : var1) : null;
   }

   public static int n(int var0) {
      List var1 = (List)jZ.get(var0);
      if (var1 != null) {
         ArrayList var2;
         synchronized(var1) {
            var2 = new ArrayList(var1);
         }

         return (Integer)Collections.max(var2) / 50;
      } else {
         return 0;
      }
   }
}
