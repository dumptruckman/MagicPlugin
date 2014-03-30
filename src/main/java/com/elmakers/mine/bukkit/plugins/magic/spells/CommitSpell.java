package com.elmakers.mine.bukkit.plugins.magic.spells;

import org.bukkit.entity.Player;

import com.elmakers.mine.bukkit.plugins.magic.Mage;
import com.elmakers.mine.bukkit.plugins.magic.Spell;
import com.elmakers.mine.bukkit.plugins.magic.SpellResult;
import com.elmakers.mine.bukkit.utilities.Target;
import com.elmakers.mine.bukkit.utilities.borrowed.ConfigurationNode;

public class CommitSpell extends Spell
{
	@Override
	public SpellResult onCast(ConfigurationNode parameters) 
	{
		// You should really use /magic commit for this at this point.
		String typeString = parameters.getString("type", "");
		if (typeString.equalsIgnoreCase("all")) {
			return controller.commitAll() ? SpellResult.CAST : SpellResult.FAIL;
		}

		Target target = getTarget();
		if (target.hasEntity() && target.getEntity() instanceof Player)
		{
			Mage mage = controller.getMage((Player)target.getEntity());
			return mage.commit() ? SpellResult.CAST : SpellResult.FAIL;
		}
		
		return mage.commit() ? SpellResult.CAST : SpellResult.FAIL;
	}
}
