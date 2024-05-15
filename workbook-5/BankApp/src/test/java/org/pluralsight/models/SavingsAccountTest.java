package org.pluralsight.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SavingsAccountTest
{
    private SavingsAccount account;
    @BeforeEach
    public void setUp()
    {
        account = new SavingsAccount(111, "Charlie", 3000);
    }

    @Test
    public void canWithdraw_shouldReturnFalse_ifWithdrawalAmount_isTooHigh()
    {
        // arrange
        double withdrawalAmount = 3100;

        // act
        boolean canWithdraw = account.canWithdraw(withdrawalAmount);

        // arrange
        assertFalse(canWithdraw, "Because the saving account had a balance of $3000, and I tried to withdraw $3100. $25 min. balance");
    }

    @Test
    void canWithdraw()
    {
    }
}