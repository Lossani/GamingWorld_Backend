package com.gamingworld.app.gamingworld.profile.resource;


import com.gamingworld.app.gamingworld.profile.domain.model.entity.FavoriteGame;
import com.gamingworld.app.gamingworld.profile.domain.model.entity.GameExperience;
import com.gamingworld.app.gamingworld.profile.domain.model.entity.StreamerSponsor;
import com.gamingworld.app.gamingworld.profile.domain.model.entity.TournamentExperience;
import com.gamingworld.app.gamingworld.security.domain.model.entity.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
public class ProfileResource {
    private Long id;
    private User user;
    private List<GameExperience> gameExperiences;
    private List<FavoriteGame> favouriteGames;
    private List<StreamerSponsor> streamerSponsors ;
    private List<TournamentExperience> tournamentExperiences ;
}
