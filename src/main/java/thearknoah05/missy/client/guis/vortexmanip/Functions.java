package thearknoah05.missy.client.guis.vortexmanip;

import net.tardis.mod.misc.vm.*;
import thearknoah05.missy.client.guis.vortexmanip.functions.WaypointFunction;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Functions extends VortexMFunctions {

    private static Map<Integer, ParentFunction> FUNCTIONS = new HashMap();
    private static Map<Integer, IVortexMFunction> BATTERY_SUB_FUNCTIONS = Collections.unmodifiableMap(new HashMap<Integer, IVortexMFunction>() {
        private static final long serialVersionUID = 1L;

        {
            this.putIfAbsent(0, new BatteryFunction());
            this.putIfAbsent(1, new ScannerSubFunction(new BatteryFunction()));
        }
    });
    private static Map<Integer, IVortexMFunction> TELEPORT_SUB_FUNCTIONS = Collections.unmodifiableMap(new HashMap<Integer, IVortexMFunction>() {
        private static final long serialVersionUID = 1L;

        {
            this.putIfAbsent(0, new TeleportFunction());
            this.putIfAbsent(1, new DistressSubFunction(new TeleportFunction()));
            this.putIfAbsent(2, new WaypointFunction());
        }
    });

    public Functions() {
    }

    public static void init() {
        FUNCTIONS.put(0, new TeleportFunction(TELEPORT_SUB_FUNCTIONS));
        FUNCTIONS.put(1, new BatteryFunction(BATTERY_SUB_FUNCTIONS));
        FUNCTIONS.put(2, new WaypointFunction(BATTERY_SUB_FUNCTIONS));
    }

    public static ParentFunction getFunction(Integer id) {
        return FUNCTIONS.containsKey(id) ? (ParentFunction)FUNCTIONS.get(id) : (ParentFunction)FUNCTIONS.get(id);
    }

    public static IVortexMFunction getVMFunction(int id, int subFunction, boolean isSubFunction) {
        if (isSubFunction) {
            return (IVortexMFunction)(getFunction(id).getSubFunctionList().containsKey(subFunction) ? getFunction(id).getSubFunctionById(subFunction) : getFunction(id));
        } else {
            return getFunction(id);
        }
    }

    public static Map<Integer, ParentFunction> getFunctionList() {
        return FUNCTIONS;
    }
}
