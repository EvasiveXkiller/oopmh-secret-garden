package secretGarden.interfaces;

import java.time.LocalDateTime;

/**
 * Interface for customer class
 */
public interface customerInterface {
    /**
     * Sets if the user can be premium
     *
     * @param eligible set to true if eligible
     */
    void setMembershipEligibility(boolean eligible);

    /**
     * Updates the membership, date is set to today
     *
     * @return The next expiration date
     */
    LocalDateTime updateMembershipStatus();
}
