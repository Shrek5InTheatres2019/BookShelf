package me.MitchT.BookShelf;

import org.bukkit.Material;

import com.google.common.collect.HashBiMap;

/**
 * 
 * BookShelf - A Bukkit & Spigot mod allowing the placement of items
 * into BookShelves. <br>
 * Copyright (C) 2012-2014 Mitch Talmadge (mitcht@aptitekk.com)<br>
 * <br>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or (at
 * your option) any later version.<br>
 * <br>
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.<br>
 * <br>
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307
 * USA
 * 
 * @author Mitch Talmadge (mitcht@aptitekk.com)
 */
public abstract class OldIDEnum
{
    private static HashBiMap<Integer, Material> materials = OldIDEnum
            .setupMap();
    
    public static Material getMaterialById(int id)
    {
        return materials.get(id);
    }
    
    public static int getIdOfMaterial(Material pMat)
    {
        return materials.inverse().get(pMat);
    }
    
    public static HashBiMap<Integer, Material> setupMap()
    {
        HashBiMap<Integer, Material> retmap = HashBiMap.create();
        
        retmap.put(0, Material.AIR);
        retmap.put(1, Material.STONE);
        retmap.put(2, Material.GRASS);
        retmap.put(3, Material.DIRT);
        retmap.put(4, Material.COBBLESTONE);
        retmap.put(5, Material.LEGACY_WOOD);
        retmap.put(6, Material.LEGACY_SAPLING);
        retmap.put(7, Material.BEDROCK);
        retmap.put(8, Material.WATER);
        retmap.put(9, Material.LEGACY_STATIONARY_WATER);
        retmap.put(10, Material.LAVA);
        retmap.put(11, Material.LEGACY_STATIONARY_LAVA);
        retmap.put(12, Material.SAND);
        retmap.put(13, Material.GRAVEL);
        retmap.put(14, Material.GOLD_ORE);
        retmap.put(15, Material.IRON_ORE);
        retmap.put(16, Material.COAL_ORE);
        retmap.put(17, Material.LEGACY_LOG);
        retmap.put(18, Material.LEGACY_LEAVES);
        retmap.put(19, Material.SPONGE);
        retmap.put(20, Material.GLASS);
        retmap.put(21, Material.LAPIS_ORE);
        retmap.put(22, Material.LAPIS_BLOCK);
        retmap.put(23, Material.DISPENSER);
        retmap.put(24, Material.SANDSTONE);
        retmap.put(25, Material.NOTE_BLOCK);
        retmap.put(26, Material.LEGACY_BED_BLOCK);
        retmap.put(27, Material.POWERED_RAIL);
        retmap.put(28, Material.DETECTOR_RAIL);
        retmap.put(29, Material.LEGACY_PISTON_STICKY_BASE);
        retmap.put(30, Material.LEGACY_WEB);
        retmap.put(31, Material.LEGACY_LONG_GRASS);
        retmap.put(32, Material.DEAD_BUSH);
        retmap.put(33, Material.LEGACY_PISTON_BASE);
        retmap.put(34, Material.LEGACY_PISTON_EXTENSION);
        retmap.put(35, Material.LEGACY_WOOL);
        retmap.put(36, Material.LEGACY_PISTON_MOVING_PIECE);
        retmap.put(37, Material.LEGACY_YELLOW_FLOWER);
        retmap.put(38, Material.LEGACY_RED_ROSE);
        retmap.put(39, Material.BROWN_MUSHROOM);
        retmap.put(40, Material.RED_MUSHROOM);
        retmap.put(41, Material.GOLD_BLOCK);
        retmap.put(42, Material.IRON_BLOCK);
        retmap.put(43, Material.LEGACY_DOUBLE_STEP);
        retmap.put(44, Material.LEGACY_STEP);
        retmap.put(45, Material.BRICK);
        retmap.put(46, Material.TNT);
        retmap.put(47, Material.BOOKSHELF);
        retmap.put(48, Material.MOSSY_COBBLESTONE);
        retmap.put(49, Material.OBSIDIAN);
        retmap.put(50, Material.TORCH);
        retmap.put(51, Material.FIRE);
        retmap.put(52, Material.LEGACY_MOB_SPAWNER);
        retmap.put(53, Material.LEGACY_WOOD_STAIRS);
        retmap.put(54, Material.CHEST);
        retmap.put(55, Material.REDSTONE_WIRE);
        retmap.put(56, Material.DIAMOND_ORE);
        retmap.put(57, Material.DIAMOND_BLOCK);
        retmap.put(58, Material.LEGACY_WORKBENCH);
        retmap.put(59, Material.LEGACY_CROPS);
        retmap.put(60, Material.LEGACY_SOIL);
        retmap.put(61, Material.FURNACE);
        retmap.put(62, Material.LEGACY_BURNING_FURNACE);
        retmap.put(63, Material.LEGACY_SIGN_POST);
        retmap.put(64, Material.LEGACY_WOODEN_DOOR);
        retmap.put(65, Material.LADDER);
        retmap.put(66, Material.LEGACY_RAILS);
        retmap.put(67, Material.COBBLESTONE_STAIRS);
        retmap.put(68, Material.LEGACY_WALL_SIGN);
        retmap.put(69, Material.LEVER);
        retmap.put(70, Material.LEGACY_STONE_PLATE);
        retmap.put(71, Material.LEGACY_IRON_DOOR_BLOCK);
        retmap.put(72, Material.LEGACY_WOOD_PLATE);
        retmap.put(73, Material.REDSTONE_ORE);
        retmap.put(74, Material.LEGACY_GLOWING_REDSTONE_ORE);
        retmap.put(75, Material.LEGACY_REDSTONE_TORCH_OFF);
        retmap.put(76, Material.LEGACY_REDSTONE_TORCH_ON);
        retmap.put(77, Material.STONE_BUTTON);
        retmap.put(78, Material.SNOW);
        retmap.put(79, Material.ICE);
        retmap.put(80, Material.SNOW_BLOCK);
        retmap.put(81, Material.CACTUS);
        retmap.put(82, Material.CLAY);
        retmap.put(83, Material.LEGACY_SUGAR_CANE_BLOCK);
        retmap.put(84, Material.JUKEBOX);
        retmap.put(85, Material.LEGACY_FENCE);
        retmap.put(86, Material.PUMPKIN);
        retmap.put(87, Material.NETHERRACK);
        retmap.put(88, Material.SOUL_SAND);
        retmap.put(89, Material.GLOWSTONE);
        retmap.put(90, Material.LEGACY_PORTAL);
        retmap.put(91, Material.JACK_O_LANTERN);
        retmap.put(92, Material.LEGACY_CAKE_BLOCK);
        retmap.put(93, Material.LEGACY_DIODE_BLOCK_OFF);
        retmap.put(94, Material.LEGACY_DIODE_BLOCK_ON);
        retmap.put(96, Material.LEGACY_TRAP_DOOR);
        retmap.put(97, Material.LEGACY_MONSTER_EGGS);
        retmap.put(98, Material.LEGACY_SMOOTH_BRICK);
        retmap.put(99, Material.LEGACY_HUGE_MUSHROOM_1);
        retmap.put(100, Material.LEGACY_HUGE_MUSHROOM_2);
        retmap.put(101, Material.LEGACY_IRON_FENCE);
        retmap.put(102, Material.LEGACY_THIN_GLASS);
        retmap.put(103, Material.LEGACY_MELON_BLOCK);
        retmap.put(104, Material.PUMPKIN_STEM);
        retmap.put(105, Material.MELON_STEM);
        retmap.put(106, Material.VINE);
        retmap.put(107, Material.LEGACY_FENCE_GATE);
        retmap.put(108, Material.BRICK_STAIRS);
        retmap.put(109, Material.LEGACY_SMOOTH_STAIRS);
        retmap.put(110, Material.LEGACY_MYCEL);
        retmap.put(111, Material.LEGACY_WATER_LILY);
        retmap.put(112, Material.NETHER_BRICK);
        retmap.put(113, Material.LEGACY_NETHER_FENCE);
        retmap.put(114, Material.NETHER_BRICK_STAIRS);
        retmap.put(115, Material.LEGACY_NETHER_WARTS);
        retmap.put(116, Material.LEGACY_ENCHANTMENT_TABLE);
        retmap.put(117, Material.BREWING_STAND);
        retmap.put(118, Material.CAULDRON);
        retmap.put(119, Material.LEGACY_ENDER_PORTAL);
        retmap.put(120, Material.LEGACY_ENDER_PORTAL_FRAME);
        retmap.put(121, Material.LEGACY_ENDER_STONE);
        retmap.put(122, Material.DRAGON_EGG);
        retmap.put(123, Material.LEGACY_REDSTONE_LAMP_OFF);
        retmap.put(124, Material.LEGACY_REDSTONE_LAMP_ON);
        retmap.put(125, Material.LEGACY_WOOD_DOUBLE_STEP);
        retmap.put(126, Material.LEGACY_WOOD_STEP);
        retmap.put(127, Material.COCOA);
        retmap.put(128, Material.SANDSTONE_STAIRS);
        retmap.put(129, Material.EMERALD_ORE);
        retmap.put(130, Material.ENDER_CHEST);
        retmap.put(131, Material.TRIPWIRE_HOOK);
        retmap.put(132, Material.TRIPWIRE);
        retmap.put(133, Material.EMERALD_BLOCK);
        retmap.put(134, Material.LEGACY_SPRUCE_WOOD_STAIRS);
        retmap.put(135, Material.LEGACY_BIRCH_WOOD_STAIRS);
        retmap.put(136, Material.LEGACY_JUNGLE_WOOD_STAIRS);
        retmap.put(137, Material.LEGACY_COMMAND);
        retmap.put(138, Material.BEACON);
        retmap.put(139, Material.LEGACY_COBBLE_WALL);
        retmap.put(140, Material.FLOWER_POT);
        retmap.put(141, Material.CARROT);
        retmap.put(142, Material.POTATO);
        retmap.put(143, Material.LEGACY_WOOD_BUTTON);
        retmap.put(144, Material.LEGACY_SKULL);
        retmap.put(145, Material.ANVIL);
        retmap.put(146, Material.TRAPPED_CHEST);
        retmap.put(147, Material.LEGACY_GOLD_PLATE);
        retmap.put(148, Material.LEGACY_IRON_PLATE);
        retmap.put(149, Material.LEGACY_REDSTONE_COMPARATOR_OFF);
        retmap.put(150, Material.LEGACY_REDSTONE_COMPARATOR_ON);
        retmap.put(151, Material.DAYLIGHT_DETECTOR);
        retmap.put(152, Material.REDSTONE_BLOCK);
        retmap.put(153, Material.LEGACY_QUARTZ_ORE);
        retmap.put(154, Material.HOPPER);
        retmap.put(155, Material.QUARTZ_BLOCK);
        retmap.put(156, Material.QUARTZ_STAIRS);
        retmap.put(157, Material.ACTIVATOR_RAIL);
        retmap.put(158, Material.DROPPER);
        retmap.put(159, Material.LEGACY_STAINED_CLAY);
        retmap.put(170, Material.HAY_BLOCK);
        retmap.put(171, Material.LEGACY_CARPET);
        retmap.put(172, Material.LEGACY_HARD_CLAY);
        retmap.put(173, Material.COAL_BLOCK);
        retmap.put(256, Material.LEGACY_IRON_SPADE);
        retmap.put(257, Material.IRON_PICKAXE);
        retmap.put(258, Material.IRON_AXE);
        retmap.put(259, Material.FLINT_AND_STEEL);
        retmap.put(260, Material.APPLE);
        retmap.put(261, Material.BOW);
        retmap.put(262, Material.ARROW);
        retmap.put(263, Material.COAL);
        retmap.put(264, Material.DIAMOND);
        retmap.put(265, Material.IRON_INGOT);
        retmap.put(266, Material.GOLD_INGOT);
        retmap.put(267, Material.IRON_SWORD);
        retmap.put(268, Material.LEGACY_WOOD_SWORD);
        retmap.put(269, Material.LEGACY_WOOD_SPADE);
        retmap.put(270, Material.LEGACY_WOOD_PICKAXE);
        retmap.put(271, Material.LEGACY_WOOD_AXE);
        retmap.put(272, Material.STONE_SWORD);
        retmap.put(273, Material.LEGACY_STONE_SPADE);
        retmap.put(274, Material.STONE_PICKAXE);
        retmap.put(275, Material.STONE_AXE);
        retmap.put(276, Material.DIAMOND_SWORD);
        retmap.put(277, Material.LEGACY_DIAMOND_SPADE);
        retmap.put(278, Material.DIAMOND_PICKAXE);
        retmap.put(279, Material.DIAMOND_AXE);
        retmap.put(280, Material.STICK);
        retmap.put(281, Material.BOWL);
        retmap.put(282, Material.LEGACY_MUSHROOM_SOUP);
        retmap.put(283, Material.LEGACY_GOLD_SWORD);
        retmap.put(284, Material.LEGACY_GOLD_SPADE);
        retmap.put(285, Material.LEGACY_GOLD_PICKAXE);
        retmap.put(286, Material.LEGACY_GOLD_AXE);
        retmap.put(287, Material.STRING);
        retmap.put(288, Material.FEATHER);
        retmap.put(289, Material.LEGACY_SULPHUR);
        retmap.put(290, Material.LEGACY_WOOD_HOE);
        retmap.put(291, Material.STONE_HOE);
        retmap.put(292, Material.IRON_HOE);
        retmap.put(293, Material.DIAMOND_HOE);
        retmap.put(294, Material.LEGACY_GOLD_HOE);
        retmap.put(295, Material.LEGACY_SEEDS);
        retmap.put(296, Material.WHEAT);
        retmap.put(297, Material.BREAD);
        retmap.put(298, Material.LEATHER_HELMET);
        retmap.put(299, Material.LEATHER_CHESTPLATE);
        retmap.put(300, Material.LEATHER_LEGGINGS);
        retmap.put(301, Material.LEATHER_BOOTS);
        retmap.put(302, Material.CHAINMAIL_HELMET);
        retmap.put(303, Material.CHAINMAIL_CHESTPLATE);
        retmap.put(304, Material.CHAINMAIL_LEGGINGS);
        retmap.put(305, Material.CHAINMAIL_BOOTS);
        retmap.put(306, Material.IRON_HELMET);
        retmap.put(307, Material.IRON_CHESTPLATE);
        retmap.put(308, Material.IRON_LEGGINGS);
        retmap.put(309, Material.IRON_BOOTS);
        retmap.put(310, Material.DIAMOND_HELMET);
        retmap.put(311, Material.DIAMOND_CHESTPLATE);
        retmap.put(312, Material.DIAMOND_LEGGINGS);
        retmap.put(313, Material.DIAMOND_BOOTS);
        retmap.put(314, Material.LEGACY_GOLD_HELMET);
        retmap.put(315, Material.LEGACY_GOLD_CHESTPLATE);
        retmap.put(316, Material.LEGACY_GOLD_LEGGINGS);
        retmap.put(317, Material.LEGACY_GOLD_BOOTS);
        retmap.put(318, Material.FLINT);
        retmap.put(319, Material.LEGACY_PORK);
        retmap.put(320, Material.LEGACY_GRILLED_PORK);
        retmap.put(321, Material.PAINTING);
        retmap.put(322, Material.GOLDEN_APPLE);
        retmap.put(323, Material.LEGACY_SIGN);
        retmap.put(324, Material.LEGACY_WOOD_DOOR);
        retmap.put(325, Material.BUCKET);
        retmap.put(326, Material.WATER_BUCKET);
        retmap.put(327, Material.LAVA_BUCKET);
        retmap.put(328, Material.MINECART);
        retmap.put(329, Material.SADDLE);
        retmap.put(330, Material.IRON_DOOR);
        retmap.put(331, Material.REDSTONE);
        retmap.put(332, Material.LEGACY_SNOW_BALL);
        retmap.put(333, Material.LEGACY_BOAT);
        retmap.put(334, Material.LEATHER);
        retmap.put(335, Material.MILK_BUCKET);
        retmap.put(336, Material.LEGACY_CLAY_BRICK);
        retmap.put(337, Material.CLAY_BALL);
        retmap.put(338, Material.SUGAR_CANE);
        retmap.put(339, Material.PAPER);
        retmap.put(340, Material.BOOK);
        retmap.put(341, Material.SLIME_BALL);
        retmap.put(342, Material.LEGACY_STORAGE_MINECART);
        retmap.put(343, Material.LEGACY_POWERED_MINECART);
        retmap.put(344, Material.EGG);
        retmap.put(345, Material.COMPASS);
        retmap.put(346, Material.FISHING_ROD);
        retmap.put(347, Material.CLOCK);
        retmap.put(348, Material.GLOWSTONE_DUST);
        retmap.put(349, Material.LEGACY_RAW_FISH);
        retmap.put(350, Material.LEGACY_COOKED_FISH);
        retmap.put(351, Material.LEGACY_INK_SACK);
        retmap.put(352, Material.BONE);
        retmap.put(353, Material.SUGAR);
        retmap.put(354, Material.CAKE);
        retmap.put(355, Material.LEGACY_BED);
        retmap.put(356, Material.LEGACY_DIODE);
        retmap.put(357, Material.COOKIE);
        retmap.put(358, Material.MAP);
        retmap.put(359, Material.SHEARS);
        retmap.put(360, Material.MELON);
        retmap.put(361, Material.PUMPKIN_SEEDS);
        retmap.put(362, Material.MELON_SEEDS);
        retmap.put(363, Material.LEGACY_RAW_BEEF);
        retmap.put(364, Material.COOKED_BEEF);
        retmap.put(365, Material.LEGACY_RAW_CHICKEN);
        retmap.put(366, Material.COOKED_CHICKEN);
        retmap.put(367, Material.ROTTEN_FLESH);
        retmap.put(368, Material.ENDER_PEARL);
        retmap.put(369, Material.BLAZE_ROD);
        retmap.put(370, Material.GHAST_TEAR);
        retmap.put(371, Material.GOLD_NUGGET);
        retmap.put(372, Material.LEGACY_NETHER_STALK);
        retmap.put(373, Material.POTION);
        retmap.put(374, Material.GLASS_BOTTLE);
        retmap.put(375, Material.SPIDER_EYE);
        retmap.put(376, Material.FERMENTED_SPIDER_EYE);
        retmap.put(377, Material.BLAZE_POWDER);
        retmap.put(378, Material.MAGMA_CREAM);
        retmap.put(379, Material.LEGACY_BREWING_STAND_ITEM);
        retmap.put(380, Material.LEGACY_CAULDRON_ITEM);
        retmap.put(381, Material.LEGACY_EYE_OF_ENDER);
        retmap.put(382, Material.LEGACY_SPECKLED_MELON);
        retmap.put(383, Material.LEGACY_MONSTER_EGG);
        retmap.put(384, Material.LEGACY_EXP_BOTTLE);
        retmap.put(385, Material.LEGACY_FIREBALL);
        retmap.put(386, Material.LEGACY_BOOK_AND_QUILL);
        retmap.put(387, Material.WRITTEN_BOOK);
        retmap.put(388, Material.EMERALD);
        retmap.put(389, Material.ITEM_FRAME);
        retmap.put(390, Material.LEGACY_FLOWER_POT_ITEM);
        retmap.put(391, Material.LEGACY_CARROT_ITEM);
        retmap.put(392, Material.LEGACY_POTATO_ITEM);
        retmap.put(393, Material.BAKED_POTATO);
        retmap.put(394, Material.POISONOUS_POTATO);
        retmap.put(395, Material.LEGACY_EMPTY_MAP);
        retmap.put(396, Material.GOLDEN_CARROT);
        retmap.put(397, Material.LEGACY_SKULL_ITEM);
        retmap.put(398, Material.LEGACY_CARROT_STICK);
        retmap.put(399, Material.NETHER_STAR);
        retmap.put(400, Material.PUMPKIN_PIE);
        retmap.put(401, Material.LEGACY_FIREWORK);
        retmap.put(402, Material.LEGACY_FIREWORK_CHARGE);
        retmap.put(403, Material.ENCHANTED_BOOK);
        retmap.put(404, Material.LEGACY_REDSTONE_COMPARATOR);
        retmap.put(405, Material.LEGACY_NETHER_BRICK_ITEM);
        retmap.put(406, Material.QUARTZ);
        retmap.put(407, Material.LEGACY_EXPLOSIVE_MINECART);
        retmap.put(408, Material.HOPPER_MINECART);
        retmap.put(417, Material.LEGACY_IRON_BARDING);
        retmap.put(418, Material.LEGACY_GOLD_BARDING);
        retmap.put(419, Material.LEGACY_DIAMOND_BARDING);
        retmap.put(420, Material.LEGACY_LEASH);
        retmap.put(421, Material.NAME_TAG);
        retmap.put(2256, Material.LEGACY_GOLD_RECORD);
        retmap.put(2257, Material.LEGACY_GREEN_RECORD);
        retmap.put(2258, Material.LEGACY_RECORD_3);
        retmap.put(2259, Material.LEGACY_RECORD_4);
        retmap.put(2260, Material.LEGACY_RECORD_5);
        retmap.put(2261, Material.LEGACY_RECORD_6);
        retmap.put(2262, Material.LEGACY_RECORD_7);
        retmap.put(2263, Material.LEGACY_RECORD_8);
        retmap.put(2264, Material.LEGACY_RECORD_9);
        retmap.put(2265, Material.LEGACY_RECORD_10);
        retmap.put(2266, Material.LEGACY_RECORD_11);
        retmap.put(2267, Material.LEGACY_RECORD_12);
        
        return retmap;
    }
}
