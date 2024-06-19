/*
  ==============================================================================

    WaxyState.cpp
    Created: 16 Jun 2024 6:49:48pm
    Author:  jakep

  ==============================================================================
*/

#include "WaxyState.h"

JUCE_IMPLEMENT_SINGLETON(WaxyState)

void WaxyState::changeListenerCallback(juce::ChangeBroadcaster *source)
{
    if (source == &transportSource)
    {
        if (transportSource.isPlaying())
            changeState(Playing);
        else
            changeState(Stopped);
    }
}

void WaxyState::changeState(TransportState newState)
{
    if (state != newState)
    {
        state = newState;

        switch (state)
        {
        case Stopped:
            transportSource.setPosition(0.0);
            break;

        case Starting:
            transportSource.start();
            break;

        case Playing:
            break;

        case Stopping:
            transportSource.stop();
            break;
        }
    }
}
