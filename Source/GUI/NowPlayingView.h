#pragma once

#include <JuceHeader.h>

class NowPlayingView : public juce::Component,
                       public juce::Button::Listener
{
public:
    virtual ~NowPlayingView() = default;
    NowPlayingView();
    NowPlayingView(const NowPlayingView &) = default;
    NowPlayingView(NowPlayingView &&) = default;

    NowPlayingView &operator=(const NowPlayingView &) = default;
    NowPlayingView &operator=(NowPlayingView &&) = default;

    // juce::Component
    void paint(juce::Graphics &g) final;
    void resized() final;

    // juce::Button::Listener
    void buttonClicked(juce::Button *button) final;

private:
    juce::TextButton playButton_;
    juce::TextButton nextButton_;
    juce::TextButton prevButton_;
};
