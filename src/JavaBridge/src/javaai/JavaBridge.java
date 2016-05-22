package javaai;

import com.springrts.ai.oo.*;
import com.springrts.ai.oo.clb.*;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;
import java.io.IOException;
import microsoft.aspnet.signalr.client.hubs.*;

public class JavaBridge extends AbstractOOAI {
    
    private OOAICallback Callback;
    private final String LogLocation = "C:\\Users\\msm8b\\Documents\\JavaBridgeLog.txt";
    
    private void Log(String message) {
        try
        {
            Writer output = new BufferedWriter(new FileWriter(LogLocation, true));
            output.append(message + "\n");
            output.close();
        }
        catch(IOException ex){
            //cant do anythying here
        }
    }
        
    @Override
    public int init(int teamId, OOAICallback callback) {
        Callback = callback;
        Log("initted");
        return 0;
    }

    @Override
    public int unitFinished(Unit unit) {
        return 0;
    }

    @Override
    public int commandFinished(Unit arg0, int i, int i1) {
        return 0;
    }

    @Override
    public int enemyCreated(Unit arg0) {
        return 0;
    }

    @Override
    public int enemyDamaged(Unit unit, Unit unit1, float f, AIFloat3 aif, WeaponDef wd, boolean bln) {
        return 0;
    }

    @Override
    public int enemyDestroyed(Unit unit, Unit uni1) {

        return 0;
    }

    @Override
    public int enemyEnterLOS(Unit unit) {
        return 0;
    }

    @Override
    public int enemyEnterRadar(Unit unit) {
        return 0;
    }

    @Override
    public int enemyFinished(Unit unit) {
        return 0;
    }

    @Override
    public int enemyLeaveLOS(Unit unit) {
        return 0;
    }

    @Override
    public int enemyLeaveRadar(Unit unit) {
        return 0;
    }

    @Override
    public int save(String string) {
        return 0;
    }

    @Override
    public int seismicPing(AIFloat3 aif, float f) {
        return 0;
    }

    @Override
    public int playerCommand(List<Unit> list, int i, int i1) {
        return 0;
    }

    @Override
    public int weaponFired(Unit unit, WeaponDef wd) {
        return 0;
    }

    @Override
    public int unitCaptured(Unit unit, int i, int i1) {
        return 0;
    }

    @Override
    public int unitGiven(Unit unit, int i, int i1) {
        return 0;
    }

    @Override
    public int unitDestroyed(Unit unit, Unit unit1) {
        return 0;
    }

    @Override
    public int unitDamaged(Unit unit, Unit unit1, float f, AIFloat3 aif, WeaponDef wd, boolean bln) {
        return 0;
    }

    @Override
    public int unitMoveFailed(Unit unit) {
        return 0;
    }

    @Override
    public int unitIdle(Unit unit) {
        return 0;
    }

    @Override
    public int unitCreated(Unit unit, Unit unit1) {
        return 0;
    }

    @Override
    public int message(int i, String string) {
        return 0;
    }

    @Override
    public int update(int i) {
        Callback.getGame().sendTextMessage("Hello, worlds!", 0);
        return 0;
    }

    @Override
    public int release(int i) {
        return 0;
    }

    @Override
    public int load(String string) {
        return 0;
    }

    @Override
    public int luaMessage(String string) {
        return 0;
    }
}
