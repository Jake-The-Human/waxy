#include "WaxyState.h"


WaxyState::~WaxyState()
{
    formatManager.clearFormats();
    transportSource.removeAllChangeListeners();
};

WaxyState::WaxyState()
{
    formatManager.registerBasicFormats();
    transportSource.addChangeListener(this);
}

void WaxyState::changeListenerCallback(juce::ChangeBroadcaster *source)
{
    if (source == &transportSource)
    {
        if (transportSource.isPlaying())
            changeState(Playing);
        else
            changeState(Stopped);
    }

    sendChangeMessage();
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
