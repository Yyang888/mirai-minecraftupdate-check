// Mirai Minecraft Update Checker
//  Copyright (C) 2022 DreamOneX
//
//  This program is free software: you can redistribute it and/or modify
//  it under the terms of the GNU Affero General Public License as
//  published by the Free Software Foundation, either version 3 of the
//  License, or any later version.
//
//  This program is distributed in the hope that it will be useful,
//  but WITHOUT ANY WARRANTY; without even the implied warranty of
//  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//  GNU Affero General Public License for more details.
//
//  You should have received a copy of the GNU Affero General Public License
//  along with this program.  If not, see <https://www.gnu.org/licenses/>.

package com.github.dreamonex.mcupdatecheck.timer;

import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import com.github.dreamonex.mcupdatecheck.check.MinecraftCheckHelper;
import com.github.dreamonex.mcupdatecheck.utils.CheckType;
import com.github.dreamonex.mcupdatecheck.utils.DataManager;

public class CheckTimer {
    Timer timer = new Timer();
    private class CheckVersionTask extends TimerTask {
        private void checkMinecraftRelease() {
            String latest = MinecraftCheckHelper.getVersion(CheckType.MC_RELEASE);
            if (DataManager.getLatestMinecraftRelease() == latest) return;
            DataManager.setLatestMinecraftRelease(latest);
            Map<Long,List<CheckType>> groups = DataManager.getGroups();
            for (Map.Entry<Long, List<CheckType>> entry: groups.entrySet()) {
                if (entry.getValue().contains(CheckType.MC_RELEASE)) {
                    
                }
            }
        }
        public void run() {
            
        }
    }
}
