
package net.mcreator.explodation.block;

import net.minecraft.block.material.Material;

@ExplodationModElements.ModElement.Tag
public class SaphireBlockBlock extends ExplodationModElements.ModElement {

	@ObjectHolder("explodation:saphire_block")
	public static final Block block = null;

	public SaphireBlockBlock(ExplodationModElements instance) {
		super(instance, 14);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {

		public CustomBlock() {
			super(

					Block.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(5f, 10f).setLightLevel(s -> 0).harvestLevel(2)
							.harvestTool(ToolType.PICKAXE).setRequiresTool());

			setRegistryName("saphire_block");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}

	}

}
