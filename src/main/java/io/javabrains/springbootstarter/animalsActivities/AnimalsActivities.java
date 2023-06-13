package io.javabrains.springbootstarter.animalsActivities;
import io.javabrains.springbootstarter.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "animalsactivities")
public class AnimalsActivities {
	
	    //@GeneratedValue(strategy = GenerationType.IDENTITY)
		//public Long id;
		@Id
		public String nickname;
		
		@Column(name = "totalstars")
		public int totalStars;
		@Column(name = "latestactivityunlocked")
		public int latestActivityUnlocked;
		@Column(name = "starsinfirstactivity")
		public int starsInFirstActivity;
		@Column(name = "starsinsecondactivity")
		public int starsInSecondActivity;
		@Column(name = "starsinthirdactivity")
		public int starsInThirdActivity;		

		@OneToOne
	    @MapsId
	    @JoinColumn()
	    private User user;
		
		public AnimalsActivities() {

		}

		public AnimalsActivities(String nickname, int totalStars, int latestActivityUnlocked, int starsInFirstActivity,
				int starsInSecondActivity, int starsInThirdActivity, User user) {
			super();
			this.nickname = nickname;
			this.totalStars = totalStars;
			this.latestActivityUnlocked = latestActivityUnlocked;
			this.starsInFirstActivity = starsInFirstActivity;
			this.starsInSecondActivity = starsInSecondActivity;
			this.starsInThirdActivity = starsInThirdActivity;
			this.user = user;
		}

		public String getNickname() {
			return nickname;
		}

		public void setNickname(String nickname) {
			this.nickname = nickname;
		}

		public int getTotalStars() {
			return totalStars;
		}

		public void setTotalStars(int totalStars) {
			this.totalStars = totalStars;
		}

		public int getLatestActivityUnlocked() {
			return latestActivityUnlocked;
		}

		public void setLatestActivityUnlocked(int latestActivityUnlocked) {
			this.latestActivityUnlocked = latestActivityUnlocked;
		}

		public int getStarsInFirstActivity() {
			return starsInFirstActivity;
		}

		public void setStarsInFirstActivity(int starsInFirstActivity) {
			this.starsInFirstActivity = starsInFirstActivity;
		}

		public int getStarsInSecondActivity() {
			return starsInSecondActivity;
		}

		public void setStarsInSecondActivity(int starsInSecondActivity) {
			this.starsInSecondActivity = starsInSecondActivity;
		}

		public int getStarsInThirdActivity() {
			return starsInThirdActivity;
		}

		public void setStarsInThirdActivity(int starsInThirdActivity) {
			this.starsInThirdActivity = starsInThirdActivity;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
			this.nickname = user.getNickname();
		}

}




