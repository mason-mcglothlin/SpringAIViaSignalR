namespace SpringAIInterface
{
    /// <summary>
    /// Status codes passed to the Release event.
    /// </summary>
    public enum ReleaseReason
    {
        Unspecified = 0,
        GameEnded = 1,
        TeamDied = 2,
        AIKilled = 3,
        AICrashed = 4,
        AIFailedToInit = 5,
        ConnectionLost = 6,
        OtherReason = 7,
    }
}
