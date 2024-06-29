#include "UrlRequests.h"

juce::URL createURL(
    const juce::String &requestType,
    const juce::StringPairArray &queryParams,
    const juce::String &postData = "")
{
  juce::URL url("http://localhost:4747/rest/" + requestType);

  // Add query parameters to the URL
  for (int i = 0; i < queryParams.size(); ++i)
  {
    url = url.withParameter(queryParams.getAllKeys()[i], queryParams.getAllValues()[i]);
  }

  // Add POST data if provided
  if (!postData.isEmpty())
  {
    url = url.withPOSTData(postData);
  }

  return url;
}

void UrlRequests::allAlbums()
{
  juce::StringPairArray queryParams;
  queryParams.set("u", "admin");
  queryParams.set("p", "admin");
  queryParams.set("c", "test");
  queryParams.set("f", "json");
  queryParams.set("type", "newest");

  // Create the URL object
  auto url = createURL("getAlbumList2", queryParams);

  juce::String headers = "Content-Type: application/json";
  int timeOutMs = 30000; // Timeout in milliseconds
  juce::StringPairArray responseHeaders;
  int statusCode = 0;
  int numRedirectsToFollow = 5; // Number of redirects to follow

  juce::URL::InputStreamOptions options(juce::URL::ParameterHandling::inAddress);

  std::unique_ptr<juce::InputStream> stream = url.createInputStream(options);

  if (stream != nullptr)
  {
    juce::String response = stream->readEntireStreamAsString();
    DBG("Response: " + response);
    DBG("Status code: " + juce::String(statusCode));

    // Print response headers
    for (int i = 0; i < responseHeaders.size(); ++i)
    {
      DBG(responseHeaders.getAllKeys()[i] + ": " + responseHeaders.getAllValues()[i]);
    }
  }
  else
  {
    DBG("Failed to create input stream!");
  }
}

Song getSong(int id) {
  juce::StringPairArray queryParams;
  queryParams.set("u", "admin");
  queryParams.set("p", "admin");
  queryParams.set("c", "test");
  queryParams.set("f", "json");
  queryParams.set("id", std::to_string(34));

  // Create the URL object
  auto url = createURL("song", queryParams);

  juce::String headers = "Content-Type: application/json";
  int timeOutMs = 30000; // Timeout in milliseconds
  juce::StringPairArray responseHeaders;
  int statusCode = 0;
  int numRedirectsToFollow = 5; // Number of redirects to follow

  juce::URL::InputStreamOptions options(juce::URL::ParameterHandling::inAddress);

  std::unique_ptr<juce::InputStream> stream = url.createInputStream(options);

  if (stream != nullptr)
  {
    juce::String response = stream->readEntireStreamAsString();
    DBG("Response: " + response);
    DBG("Status code: " + juce::String(statusCode));

    // Print response headers
    for (int i = 0; i < responseHeaders.size(); ++i)
    {
      DBG(responseHeaders.getAllKeys()[i] + ": " + responseHeaders.getAllValues()[i]);
    }
  }
  else
  {
    DBG("Failed to create input stream!");
  }

  return {};
}
