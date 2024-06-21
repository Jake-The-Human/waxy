/*
  ==============================================================================

    WaxyState.cpp
    Created: 16 Jun 2024 6:49:48pm
    Author:  jakep

  ==============================================================================
*/

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

void WaxyState::requestSongBytes(const juce::String &apiEndpoint, const juce::String &apiKey, const juce::String &songId)
{
    // // Create the URL object
    // juce::URL url(apiEndpoint);

    // // Create the JSON payload
    // juce::DynamicObject::Ptr jsonPayload = new juce::DynamicObject();
    // jsonPayload->setProperty("song_id", songId);

    // juce::String jsonString = jsonPayload->;

    // // Create a memory block for the JSON data
    // juce::MemoryBlock postData;
    // postData.append(jsonString.toRawUTF8(), jsonString.getNumBytesAsUTF8());

    // // Set up the headers
    // juce::StringPairArray headers;
    // headers.set("Authorization", "Bearer " + apiKey);
    // headers.set("Content-Type", "application/json");

    // // Create the POST request
    // auto response = url.withPOSTData(postData);

    // // Successfully retrieved song bytes
    // juce::MemoryBlock songBytes;
    // response.readEntireBinaryStream(songBytes);
}
