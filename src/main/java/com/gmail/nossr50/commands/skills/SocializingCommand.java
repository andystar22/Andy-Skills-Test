package com.gmail.nossr50.commands.skills;

import com.gmail.nossr50.datatypes.skills.PrimarySkillType;
import com.gmail.nossr50.datatypes.skills.SubSkillType;
import com.gmail.nossr50.locale.LocaleLoader;
import com.gmail.nossr50.util.Permissions;
import com.gmail.nossr50.util.random.ProbabilityUtil;
import com.gmail.nossr50.util.skills.RankUtils;
import com.gmail.nossr50.util.text.TextComponentFactory;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class SocializingCommand extends SkillCommand {

    private boolean canSpeech;

    public SocializingCommand() {
        super(PrimarySkillType.Socializing);
    }

    @Override
    protected void dataCalculations(Player player, float skillValue) {
        
    }

    @Override
    protected void permissionsCheck(Player player) {
        canSpeech = Permissions.canUseSubSkill(player, SubSkillType.SPEECH);
        
    }

    @Override
    protected List<String> statsDisplay(Player player, float skillValue, boolean hasEndurance, boolean isLucky) {
        List<String> messages = new ArrayList<>();

        if (canSpeech) {
            messages.add(getStatMessage(false, true, SubSkillType.SPEECH,
                    String.valueOf(1)));
        }

        return messages;
    }

    @Override
    protected List<Component> getTextComponents(Player player) {
        List<Component> textComponents = new ArrayList<>();

        TextComponentFactory.getSubSkillTextComponents(player, textComponents, PrimarySkillType.SOCIALIZING);

        return textComponents;
    }
}
