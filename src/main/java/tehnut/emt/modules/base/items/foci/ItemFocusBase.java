package tehnut.emt.modules.base.items.foci;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import tehnut.emt.ElectroMagicTools;
import tehnut.emt.ModInformation;
import tehnut.emt.util.TextHelper;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.wands.IWandFocus;

import java.util.List;

public class ItemFocusBase extends Item implements IWandFocus {

	private IIcon ornament, depth;

	public ItemFocusBase(String unlocName, String textureName) {
		super();

		setUnlocalizedName(ModInformation.ID + ".module.base.focus." + unlocName);
		setTextureName(ModInformation.TEXLOC + textureName);
		setCreativeTab(ElectroMagicTools.tabEMT);
		setMaxDamage(1);
		setNoRepair();
		setMaxStackSize(1);
	}

	boolean hasOrnament() {
		return false;
	}

	boolean hasDepth() {
		return false;
	}

	@Override
	public int getFocusColor() {
		return 0;
	}

	@Override
	public boolean isItemTool(ItemStack par1ItemStack) {
		return true;
	}

	@Override
	public EnumRarity getRarity(ItemStack itemstack) {
		return EnumRarity.rare;
	}

	@Override
	public IIcon getFocusDepthLayerIcon() {
		return depth;
	}

	@Override
	public IIcon getOrnament() {
		return ornament;
	}

	@Override
	public WandFocusAnimation getAnimation() {
		return WandFocusAnimation.WAVE;
	}

	@Override
	public AspectList getVisCost() {
		return null;
	}

	public boolean isUseItem() {
		return isVisCostPerTick();
	}

	@Override
	public boolean isVisCostPerTick() {
		return false;
	}

	@Override
	public ItemStack onFocusRightClick(ItemStack stack, World world, EntityPlayer player, MovingObjectPosition pmo) {
		if (isUseItem())
			player.setItemInUse(stack, Integer.MAX_VALUE);
		return stack;
	}

	@Override
	public void onUsingFocusTick(ItemStack stack, EntityPlayer player, int count) {

	}

	@Override
	public void onPlayerStoppedUsingFocus(ItemStack stack, World world, EntityPlayer player, int count) {
	}

	@Override
	public String getSortingHelper(ItemStack stack) {
		return "00";
	}

	@Override
	public boolean onFocusBlockStartBreak(ItemStack stack, int x, int y, int z, EntityPlayer player) {
		return false;
	}

	@Override
	public boolean acceptsEnchant(int id) {
		return false;
	}

	@Override
	public int getItemEnchantability() {
		return 5;
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
		AspectList cost = getVisCost();
		if (cost != null && cost.size() > 0) {
			list.add(TextHelper.localize(isVisCostPerTick() ? "item.Focus.cost2" : "item.Focus.cost1"));
			for (Aspect aspect : cost.getAspectsSorted()) {
				float amount = cost.getAmount(aspect) / 100.0F;
				list.add(" " + '\u00a7' + aspect.getChatcolor() + aspect.getName() + '\u00a7' + "r x " + amount);
			}
		}
	}
}
