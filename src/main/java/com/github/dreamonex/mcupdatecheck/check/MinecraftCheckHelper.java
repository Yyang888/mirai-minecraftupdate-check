// Mirai Minecraft Update Checker
// 	Copyright (C) 2022 DreamOneX
//
// 	This program is free software: you can redistribute it and/or modify
// 	it under the terms of the GNU Affero General Public License as
// 	published by the Free Software Foundation, either version 3 of the
// 	License, or any later version.
//
// 	This program is distributed in the hope that it will be useful,
// 	but WITHOUT ANY WARRANTY; without even the implied warranty of
// 	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// 	GNU Affero General Public License for more details.
//
// 	You should have received a copy of the GNU Affero General Public License
// 	along with this program.  If not, see <https://www.gnu.org/licenses/>.

package com.github.dreamonex.mcupdatecheck.check;

import java.net.MalformedURLException;
import java.net.URL;
import java.io.IOException;
import com.fasterxml.jackson.databind.*;
import com.github.dreamonex.mcupdatecheck.MCUpdateCheckMain;
import com.github.dreamonex.mcupdatecheck.utils.CheckType;
import com.github.dreamonex.mcupdatecheck.utils.DataManager;

public class MinecraftCheckHelper {
    public static synchronized String getVersion(CheckType ver) throws IOException {
        URL url;
        try {
            url = new URL("https://launchermeta.mojang.com/mc/game/version_manifest.json");
        } catch (MalformedURLException e) {
            MCUpdateCheckMain.INSTANCE.getLogger().error(e);
            return DataManager.getLatestMinecraftRelease();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode;
        jsonNode = objectMapper.readTree(url);
        JsonNode node = jsonNode.get("latest");
        switch(ver) {
            case MC_RELEASE:
                return node.get("release").asText();
            case MC_SNAPSHOT:
                return node.get("snapshot").asText();
            default:
                throw new IllegalArgumentException("Invalid check type");
        }
    }
}
