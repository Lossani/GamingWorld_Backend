package com.gamingworld.app.gamingworld.profile.resource;


import com.gamingworld.app.gamingworld.profile.domain.model.entity.*;
import com.gamingworld.app.gamingworld.security.domain.model.entity.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
public class ProfileResource {
    private Long id;
    //private User user;
    private List<GameExperience> gameExperiences;
    private List<FavoriteGame> favouriteGames;
    private List<StreamerSponsor> streamerSponsors ;
    private List<TournamentExperience> tournamentExperiences ;
    private List<StreamingCategory> streamingCategories;
}
