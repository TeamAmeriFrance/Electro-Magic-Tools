/*******************************************************************************
 * Copyright (c) 2014 Tombenpotter.
 * All rights reserved. 
 * 
 * This program and the accompanying materials are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at http://www.gnu.org/licenses/gpl.html
 * 
 * This class was made by Tombenpotter and is distributed as a part of the Electro-Magic Tools mod.
 * Electro-Magic Tools is a derivative work on Thaumcraft 4 (c) Azanor 2012.
 * http://www.minecraftforum.net/topic/1585216-
 * 
 * Attention: this class originally belongs to the ThaumicTinkerer mod.
 * All I did was modifying it to fulfill my needs.
 * 
 * ThaumicTinkerer is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * 
 * http://www.minecraftforum.net/topic/1813058-
 ******************************************************************************/
package electricMagicTools.tombenpotter.electricmagictools.common;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;
import thaumcraft.api.research.ResearchPage.PageType;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EMTResearchItem extends ResearchItem {

	public EMTResearchItem(String par1, String par2) {
		super(par1, par2);
	}

	public EMTResearchItem(String par1, String par2, AspectList tags, int par3, int par4, int par5, ItemStack icon) {
		super(par1, par2, tags, par3, par4, par5, icon);
	}

	public EMTResearchItem(String par1, String par2, AspectList tags, int par3, int par4, int par5, ResourceLocation icon) {
		super(par1, par2, tags, par3, par4, par5, icon);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public String getName() {
		return StatCollector.translateToLocal(key);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public String getText() {
		return StatCollector.translateToLocal("[EMT] ") + StatCollector.translateToLocal("emt.tag." + key);
	}

	@Override
	public ResearchItem setPages(ResearchPage... par) {
		for (ResearchPage page : par) {
			if (page.type == PageType.TEXT)
				page.text = "emt.text." + key;

			if (page.type == PageType.INFUSION_CRAFTING) {
				if (parentsHidden == null || parentsHidden.length == 0)
					parentsHidden = new String[] { "INFUSION" };
				else {
					String[] newParents = new String[parentsHidden.length + 1];
					newParents[0] = "INFUSION";
					for (int i = 0; i < parentsHidden.length; i++)
						newParents[i + 1] = parentsHidden[i];
					parentsHidden = newParents;
				}
			}
		}

		return super.setPages(par);
	}
}
