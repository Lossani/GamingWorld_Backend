package com.gamingworld.app.gamingworld.profile.resource;


import com.gamingworld.app.gamingworld.profile.domain.model.entity.*;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
public class SaveProfileResource {
    //@NotNull
    //private Long userId;

    // Relations
    private List<GameExperience> gameExperiences;
    private List<FavoriteGame> favouriteGames;
    private List<StreamerSponsor> streamerSponsors;
    private List<TournamentExperience> tournamentExperiences;
    private List<StreamingCategory> streamingCategories;
}
