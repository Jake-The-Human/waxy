#pragma once

#include <JuceHeader.h>
#include <memory>
#include "../Logic/WaxyState.h"

class NowPlayingView : public juce::Component,
                       public juce::Button::Listener
{
public:
    virtual ~NowPlayingView() = default;
    NowPlayingView(std::shared_ptr<WaxyState> waxyState);

    // juce::Component
    void paint(juce::Graphics &g) final;
    void resized() final;

    // juce::Button::Listener
    void buttonClicked(juce::Button *button) final;

private:
    std::shared_ptr<WaxyState> waxyState_;
    juce::TextButton playButton_;
    juce::TextButton nextButton_;
    juce::TextButton prevButton_;

    JUCE_DECLARE_NON_COPYABLE_WITH_LEAK_DETECTOR (NowPlayingView)
};
