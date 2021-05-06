
package net.mcreator.explodation.block;

import net.minecraft.block.material.Material;

@ExplodationModElements.ModElement.Tag
public class RottenLogBlock extends ExplodationModElements.ModElement {

	@ObjectHolder("explodation:rotten_log")
	public static final Block block = null;

	public RottenLogBlock(ExplodationModElements instance) {
		super(instance, 7);

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

					Block.Properties.create(Material.WOOD).sound(SoundType.WET_GRASS).hardnessAndResistance(0.9f, 8f).setLightLevel(s -> 0));

			setRegistryName("rotten_log");
		}

		@Override
		public boolean canSustainPlant(BlockState state, IBlockReader world, BlockPos pos, Direction direction, IPlantable plantable) {
			return true;
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
